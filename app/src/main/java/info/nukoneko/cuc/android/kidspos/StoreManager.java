package info.nukoneko.cuc.android.kidspos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import info.nukoneko.cuc.android.kidspos.util.AppSettings;
import info.nukoneko.cuc.android.kidspos.util.KPLogger;
import info.nukoneko.kidspos4j.model.ModelStaff;
import info.nukoneko.kidspos4j.model.ModelStore;

/**
 * Created by TEJNEK on 2015/10/11.
 */
public final class StoreManager {
    static private final String PREF_SAVED_STORE_NAME = "SAVED_STORE_NAME";
    static private Context applicationContext;

    static private ModelStore store;

    public StoreManager(){

    }

    static public synchronized void Initialize(Context _applicationContext){
        KPLogger.d("StoreManager Initialize");
        applicationContext = _applicationContext.getApplicationContext();

        ModelStore _store = new ModelStore();
        _store.setId(99);
        _store.setName("テスト商店");
        store = _store;
    }

    static public synchronized String getToken(){
        String token = applicationContext
                .getSharedPreferences(AppSettings.PREF_NAME, Context.MODE_PRIVATE)
                .getString(PREF_SAVED_STORE_NAME, "ストア1");
        return token;
    }

    @Nullable private static ModelStaff storeStaff;

    @Nullable
    public static synchronized ModelStaff getStoreStaff() {
        return storeStaff;
    }

    public static synchronized void setStoreStaff(@Nullable ModelStaff _storeStaff) {
        storeStaff = _storeStaff;
    }

    @NonNull
    public static synchronized  ModelStore getStore() {
        return store;
    }

    public static  synchronized void setStore(@NonNull ModelStore _store) {
        _store = store;
    }
}