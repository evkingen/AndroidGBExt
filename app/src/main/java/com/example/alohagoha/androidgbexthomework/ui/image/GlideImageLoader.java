package com.example.alohagoha.androidgbexthomework.ui.image;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.alohagoha.androidgbexthomework.App;
import com.example.alohagoha.androidgbexthomework.mvp.model.cache.ICache;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomImage;
import com.example.alohagoha.androidgbexthomework.mvp.model.image.IImageLoader;
import com.example.alohagoha.androidgbexthomework.ui.NetworkStatus;

import java.io.File;
import java.io.FileOutputStream;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class GlideImageLoader implements IImageLoader<ImageView> {

    private static final String IMAGE_DIR = "image";

    private ICache<RoomImage> imageCache;

    public GlideImageLoader(ICache<RoomImage> imageCache) {
        this.imageCache = imageCache;
    }

    public ICache<RoomImage> getImageCache() {
        return imageCache;
    }

    @Override
    public void loadInto(@Nullable String url, ImageView container) {
        if (NetworkStatus.isOnline()) {
            GlideApp.with(container.getContext()).asBitmap().load(url).listener(new RequestListener<Bitmap>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                    Timber.e(e, "Image load failed");
                    return false;
                }

                @Override
                public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                    File imageDir = new File(App.getInstance().getExternalFilesDir(null) + "/" + IMAGE_DIR);

                    if (!imageDir.exists() && !imageDir.mkdirs()) {
                        throw new RuntimeException("Failed to create directory: " + imageDir.toString());
                    }

                    final String fileFormat = ".png";
                    final File imageFile = new File(imageDir, url.hashCode() + fileFormat);
                    FileOutputStream fos;

                    try {
                        fos = new FileOutputStream(imageFile);
                        resource.compress(Bitmap.CompressFormat.PNG, 100, fos);
                        fos.close();
                    } catch (Exception e) {
                        Timber.d("Failed to save image");
                        return false;
                    }

                    imageCache.write(new RoomImage(url, imageFile.getPath()));
                    return false;
                }
            }).into(container);
        } else {
            Disposable disposable = imageCache.read(url).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(roomImage -> GlideApp.with(container.getContext())
                            .load(roomImage.getFilePath())
                            .into(container));
        }
    }

}
