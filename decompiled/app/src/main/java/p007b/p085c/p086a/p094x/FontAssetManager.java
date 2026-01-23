package p007b.p085c.p086a.p094x;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p095y.MutablePair;

/* JADX INFO: renamed from: b.c.a.x.a, reason: use source file name */
/* JADX INFO: compiled from: FontAssetManager.java */
/* JADX INFO: loaded from: classes.dex */
public class FontAssetManager {

    /* JADX INFO: renamed from: d */
    public final AssetManager f2645d;

    /* JADX INFO: renamed from: a */
    public final MutablePair<String> f2642a = new MutablePair<>();

    /* JADX INFO: renamed from: b */
    public final Map<MutablePair<String>, Typeface> f2643b = new HashMap();

    /* JADX INFO: renamed from: c */
    public final Map<String, Typeface> f2644c = new HashMap();

    /* JADX INFO: renamed from: e */
    public String f2646e = ".ttf";

    public FontAssetManager(Drawable.Callback callback) {
        if (callback instanceof View) {
            this.f2645d = ((View) callback).getContext().getAssets();
        } else {
            Logger2.m640b("LottieDrawable must be inside of a view for images to work.");
            this.f2645d = null;
        }
    }
}
