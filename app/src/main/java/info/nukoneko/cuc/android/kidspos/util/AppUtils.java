package info.nukoneko.cuc.android.kidspos.util;

import android.app.Service;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import info.nukoneko.cuc.android.kidspos.AppController;

/**
 * Created by TEJNEK on 2015/10/04.
 */
public class AppUtils {

    @Nullable
    public static View getInflateView(@NonNull Context context, @LayoutRes int resourceID) {
        try {
            return LayoutInflater.from(context).inflate(resourceID, null);
        }catch (Exception e){
            return null;
        }
    }

    @Nullable
    public static View getInflateView(@LayoutRes int resourceID) {
        Context context = AppController.get().getApplicationContext();
        try {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            return inflater.inflate(resourceID, null);
        }catch (Exception e){
            return null;
        }
    }
}