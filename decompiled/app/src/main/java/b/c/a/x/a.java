package b.c.a.x;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import b.c.a.b0.c;
import b.c.a.y.j;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public class a {
    public final AssetManager d;
    public final j<String> a = new j<>();

    /* renamed from: b, reason: collision with root package name */
    public final Map<j<String>, Typeface> f397b = new HashMap();
    public final Map<String, Typeface> c = new HashMap();
    public String e = ".ttf";

    public a(Drawable.Callback callback) {
        if (callback instanceof View) {
            this.d = ((View) callback).getContext().getAssets();
        } else {
            c.b("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        }
    }
}
