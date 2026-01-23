package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayInputStream;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLException;
import p007b.p085c.p086a.FontAssetDelegate;
import p007b.p085c.p086a.ImageAssetDelegate;
import p007b.p085c.p086a.L;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.LottieCompositionFactory;
import p007b.p085c.p086a.LottieCompositionFactory2;
import p007b.p085c.p086a.LottieCompositionFactory3;
import p007b.p085c.p086a.LottieCompositionFactory4;
import p007b.p085c.p086a.LottieCompositionFactory5;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieListener;
import p007b.p085c.p086a.LottieOnCompositionLoadedListener;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.LottieTask2;
import p007b.p085c.p086a.PerformanceTracker;
import p007b.p085c.p086a.RenderMode;
import p007b.p085c.p086a.SimpleColorFilter;
import p007b.p085c.p086a.TextDelegate;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p089b0.LottieValueAnimator;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p094x.FontAssetManager;
import p007b.p085c.p086a.p094x.ImageAssetManager;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* JADX INFO: renamed from: j */
    public static final String f14517j = LottieAnimationView.class.getSimpleName();

    /* JADX INFO: renamed from: k */
    public static final LottieListener<Throwable> f14518k = new C5407a();

    /* JADX INFO: renamed from: A */
    public int f14519A;

    /* JADX INFO: renamed from: B */
    @Nullable
    public LottieTask2<LottieComposition> f14520B;

    /* JADX INFO: renamed from: C */
    @Nullable
    public LottieComposition f14521C;

    /* JADX INFO: renamed from: l */
    public final LottieListener<LottieComposition> f14522l;

    /* JADX INFO: renamed from: m */
    public final LottieListener<Throwable> f14523m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public LottieListener<Throwable> f14524n;

    /* JADX INFO: renamed from: o */
    @DrawableRes
    public int f14525o;

    /* JADX INFO: renamed from: p */
    public final LottieDrawable f14526p;

    /* JADX INFO: renamed from: q */
    public boolean f14527q;

    /* JADX INFO: renamed from: r */
    public String f14528r;

    /* JADX INFO: renamed from: s */
    @RawRes
    public int f14529s;

    /* JADX INFO: renamed from: t */
    public boolean f14530t;

    /* JADX INFO: renamed from: u */
    public boolean f14531u;

    /* JADX INFO: renamed from: v */
    public boolean f14532v;

    /* JADX INFO: renamed from: w */
    public boolean f14533w;

    /* JADX INFO: renamed from: x */
    public boolean f14534x;

    /* JADX INFO: renamed from: y */
    public RenderMode f14535y;

    /* JADX INFO: renamed from: z */
    public Set<LottieOnCompositionLoadedListener> f14536z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C5406a();

        /* JADX INFO: renamed from: j */
        public String f14537j;

        /* JADX INFO: renamed from: k */
        public int f14538k;

        /* JADX INFO: renamed from: l */
        public float f14539l;

        /* JADX INFO: renamed from: m */
        public boolean f14540m;

        /* JADX INFO: renamed from: n */
        public String f14541n;

        /* JADX INFO: renamed from: o */
        public int f14542o;

        /* JADX INFO: renamed from: p */
        public int f14543p;

        /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$SavedState$a */
        public class C5406a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f14537j);
            parcel.writeFloat(this.f14539l);
            parcel.writeInt(this.f14540m ? 1 : 0);
            parcel.writeString(this.f14541n);
            parcel.writeInt(this.f14542o);
            parcel.writeInt(this.f14543p);
        }

        public SavedState(Parcel parcel, C5407a c5407a) {
            super(parcel);
            this.f14537j = parcel.readString();
            this.f14539l = parcel.readFloat();
            this.f14540m = parcel.readInt() == 1;
            this.f14541n = parcel.readString();
            this.f14542o = parcel.readInt();
            this.f14543p = parcel.readInt();
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$a */
    public class C5407a implements LottieListener<Throwable> {
        @Override // p007b.p085c.p086a.LottieListener
        /* JADX INFO: renamed from: a */
        public void mo680a(Throwable th) {
            Throwable th2 = th;
            PathMeasure pathMeasure = Utils.f2309a;
            if (!((th2 instanceof SocketException) || (th2 instanceof ClosedChannelException) || (th2 instanceof InterruptedIOException) || (th2 instanceof ProtocolException) || (th2 instanceof SSLException) || (th2 instanceof UnknownHostException) || (th2 instanceof UnknownServiceException))) {
                throw new IllegalStateException("Unable to parse composition", th2);
            }
            Logger2.m641c("Unable to load composition.", th2);
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$b */
    public class C5408b implements LottieListener<LottieComposition> {
        public C5408b() {
        }

        @Override // p007b.p085c.p086a.LottieListener
        /* JADX INFO: renamed from: a */
        public void mo680a(LottieComposition lottieComposition) {
            LottieAnimationView.this.setComposition(lottieComposition);
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$c */
    public class C5409c implements LottieListener<Throwable> {
        public C5409c() {
        }

        @Override // p007b.p085c.p086a.LottieListener
        /* JADX INFO: renamed from: a */
        public void mo680a(Throwable th) {
            Throwable th2 = th;
            LottieAnimationView lottieAnimationView = LottieAnimationView.this;
            int i = lottieAnimationView.f14525o;
            if (i != 0) {
                lottieAnimationView.setImageResource(i);
            }
            LottieListener<Throwable> lottieListener = LottieAnimationView.this.f14524n;
            if (lottieListener == null) {
                String str = LottieAnimationView.f14517j;
                lottieListener = LottieAnimationView.f14518k;
            }
            lottieListener.mo680a(th2);
        }
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        String string;
        super(context, attributeSet);
        this.f14522l = new C5408b();
        this.f14523m = new C5409c();
        this.f14525o = 0;
        LottieDrawable lottieDrawable = new LottieDrawable();
        this.f14526p = lottieDrawable;
        this.f14530t = false;
        this.f14531u = false;
        this.f14532v = false;
        this.f14533w = false;
        this.f14534x = true;
        this.f14535y = RenderMode.AUTOMATIC;
        this.f14536z = new HashSet();
        this.f14519A = 0;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5410R.b.LottieAnimationView, C5410R.a.lottieAnimationViewStyle, 0);
        if (!isInEditMode()) {
            this.f14534x = typedArrayObtainStyledAttributes.getBoolean(C5410R.b.LottieAnimationView_lottie_cacheComposition, true);
            int i = C5410R.b.LottieAnimationView_lottie_rawRes;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i);
            int i2 = C5410R.b.LottieAnimationView_lottie_fileName;
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(i2);
            int i3 = C5410R.b.LottieAnimationView_lottie_url;
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(i3);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(i, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(i2);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(i3)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(C5410R.b.LottieAnimationView_lottie_fallbackRes, 0));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C5410R.b.LottieAnimationView_lottie_autoPlay, false)) {
            this.f14532v = true;
            this.f14533w = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C5410R.b.LottieAnimationView_lottie_loop, false)) {
            lottieDrawable.f2371l.setRepeatCount(-1);
        }
        int i4 = C5410R.b.LottieAnimationView_lottie_repeatMode;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(i4, 1));
        }
        int i5 = C5410R.b.LottieAnimationView_lottie_repeatCount;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(i5, -1));
        }
        int i6 = C5410R.b.LottieAnimationView_lottie_speed;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(i6, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(C5410R.b.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(C5410R.b.LottieAnimationView_lottie_progress, 0.0f));
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C5410R.b.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        if (lottieDrawable.f2382w != z2) {
            lottieDrawable.f2382w = z2;
            if (lottieDrawable.f2370k != null) {
                lottieDrawable.m682b();
            }
        }
        int i7 = C5410R.b.LottieAnimationView_lottie_colorFilter;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            lottieDrawable.m681a(new KeyPath("**"), LottieProperty.f2421C, new LottieValueCallback(new SimpleColorFilter(typedArrayObtainStyledAttributes.getColor(i7, 0))));
        }
        int i8 = C5410R.b.LottieAnimationView_lottie_scale;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            lottieDrawable.f2372m = typedArrayObtainStyledAttributes.getFloat(i8, 1.0f);
            lottieDrawable.m702v();
        }
        int i9 = C5410R.b.LottieAnimationView_lottie_renderMode;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            int i10 = typedArrayObtainStyledAttributes.getInt(i9, 0);
            RenderMode.values();
            setRenderMode(RenderMode.values()[i10 >= 3 ? 0 : i10]);
        }
        if (getScaleType() != null) {
            lottieDrawable.f2377r = getScaleType();
        }
        typedArrayObtainStyledAttributes.recycle();
        Context context2 = getContext();
        PathMeasure pathMeasure = Utils.f2309a;
        Boolean boolValueOf = Boolean.valueOf(Settings.Global.getFloat(context2.getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f);
        Objects.requireNonNull(lottieDrawable);
        lottieDrawable.f2373n = boolValueOf.booleanValue();
        m7492b();
        this.f14527q = true;
    }

    private void setCompositionTask(LottieTask2<LottieComposition> lottieTask2) {
        this.f14521C = null;
        this.f14526p.m683c();
        m7491a();
        lottieTask2.m706b(this.f14522l);
        lottieTask2.m705a(this.f14523m);
        this.f14520B = lottieTask2;
    }

    /* JADX INFO: renamed from: a */
    public final void m7491a() {
        LottieTask2<LottieComposition> lottieTask2 = this.f14520B;
        if (lottieTask2 != null) {
            LottieListener<LottieComposition> lottieListener = this.f14522l;
            synchronized (lottieTask2) {
                lottieTask2.f2453b.remove(lottieListener);
            }
            LottieTask2<LottieComposition> lottieTask22 = this.f14520B;
            LottieListener<Throwable> lottieListener2 = this.f14523m;
            synchronized (lottieTask22) {
                lottieTask22.f2454c.remove(lottieListener2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7492b() {
        int iOrdinal = this.f14535y.ordinal();
        int i = 2;
        if (iOrdinal == 0) {
            LottieComposition lottieComposition = this.f14521C;
            boolean z2 = false;
            if ((lottieComposition == null || !lottieComposition.f2349n || Build.VERSION.SDK_INT >= 28) && (lottieComposition == null || lottieComposition.f2350o <= 4)) {
                z2 = true;
            }
            if (!z2) {
            }
        } else if (iOrdinal != 1) {
            i = 1;
        }
        if (i != getLayerType()) {
            setLayerType(i, null);
        }
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z2) {
        this.f14519A++;
        super.buildDrawingCache(z2);
        if (this.f14519A == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z2) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.f14519A--;
        L.m663a("buildDrawingCache");
    }

    @MainThread
    /* JADX INFO: renamed from: c */
    public void m7493c() {
        this.f14533w = false;
        this.f14532v = false;
        this.f14531u = false;
        this.f14530t = false;
        LottieDrawable lottieDrawable = this.f14526p;
        lottieDrawable.f2375p.clear();
        lottieDrawable.f2371l.m648m();
        m7492b();
    }

    @MainThread
    /* JADX INFO: renamed from: d */
    public void m7494d() {
        if (!isShown()) {
            this.f14530t = true;
        } else {
            this.f14526p.m690j();
            m7492b();
        }
    }

    @Nullable
    public LottieComposition getComposition() {
        return this.f14521C;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.f14521C;
        if (lottieComposition != null) {
            return (long) lottieComposition.m670b();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.f14526p.f2371l.f2300o;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f14526p.f2379t;
    }

    public float getMaxFrame() {
        return this.f14526p.m685e();
    }

    public float getMinFrame() {
        return this.f14526p.m686f();
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.f14526p.f2370k;
        if (lottieComposition != null) {
            return lottieComposition.f2336a;
        }
        return null;
    }

    @FloatRange(from = 0.0d, m75to = 1.0d)
    public float getProgress() {
        return this.f14526p.m687g();
    }

    public int getRepeatCount() {
        return this.f14526p.m688h();
    }

    public int getRepeatMode() {
        return this.f14526p.f2371l.getRepeatMode();
    }

    public float getScale() {
        return this.f14526p.f2372m;
    }

    public float getSpeed() {
        return this.f14526p.f2371l.f2297l;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f14526p;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f14533w || this.f14532v) {
            m7494d();
            this.f14533w = false;
            this.f14532v = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.f14526p.m689i()) {
            this.f14532v = false;
            this.f14531u = false;
            this.f14530t = false;
            LottieDrawable lottieDrawable = this.f14526p;
            lottieDrawable.f2375p.clear();
            lottieDrawable.f2371l.cancel();
            m7492b();
            this.f14532v = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f14537j;
        this.f14528r = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f14528r);
        }
        int i = savedState.f14538k;
        this.f14529s = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.f14539l);
        if (savedState.f14540m) {
            m7494d();
        }
        this.f14526p.f2379t = savedState.f14541n;
        setRepeatMode(savedState.f14542o);
        setRepeatCount(savedState.f14543p);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14537j = this.f14528r;
        savedState.f14538k = this.f14529s;
        savedState.f14539l = this.f14526p.m687g();
        savedState.f14540m = this.f14526p.m689i() || (!ViewCompat.isAttachedToWindow(this) && this.f14532v);
        LottieDrawable lottieDrawable = this.f14526p;
        savedState.f14541n = lottieDrawable.f2379t;
        savedState.f14542o = lottieDrawable.f2371l.getRepeatMode();
        savedState.f14543p = this.f14526p.m688h();
        return savedState;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        if (this.f14527q) {
            if (!isShown()) {
                if (this.f14526p.m689i()) {
                    m7493c();
                    this.f14531u = true;
                    return;
                }
                return;
            }
            if (this.f14531u) {
                if (isShown()) {
                    this.f14526p.m691k();
                    m7492b();
                } else {
                    this.f14530t = false;
                    this.f14531u = true;
                }
            } else if (this.f14530t) {
                m7494d();
            }
            this.f14531u = false;
            this.f14530t = false;
        }
    }

    public void setAnimation(@RawRes int i) {
        LottieTask2<LottieComposition> lottieTask2M674a;
        this.f14529s = i;
        this.f14528r = null;
        if (this.f14534x) {
            Context context = getContext();
            lottieTask2M674a = LottieCompositionFactory.m674a(LottieCompositionFactory.m679f(context, i), new LottieCompositionFactory4(new WeakReference(context), context.getApplicationContext(), i));
        } else {
            Context context2 = getContext();
            Map<String, LottieTask2<LottieComposition>> map = LottieCompositionFactory.f2351a;
            lottieTask2M674a = LottieCompositionFactory.m674a(null, new LottieCompositionFactory4(new WeakReference(context2), context2.getApplicationContext(), i));
        }
        setCompositionTask(lottieTask2M674a);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setCompositionTask(LottieCompositionFactory.m674a(null, new LottieCompositionFactory5(new ByteArrayInputStream(str.getBytes()), null)));
    }

    public void setAnimationFromUrl(String str) {
        LottieTask2<LottieComposition> lottieTask2M674a;
        if (this.f14534x) {
            Context context = getContext();
            Map<String, LottieTask2<LottieComposition>> map = LottieCompositionFactory.f2351a;
            String strM883w = outline.m883w("url_", str);
            lottieTask2M674a = LottieCompositionFactory.m674a(strM883w, new LottieCompositionFactory2(context, str, strM883w));
        } else {
            lottieTask2M674a = LottieCompositionFactory.m674a(null, new LottieCompositionFactory2(getContext(), str, null));
        }
        setCompositionTask(lottieTask2M674a);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z2) {
        this.f14526p.f2366A = z2;
    }

    public void setCacheComposition(boolean z2) {
        this.f14534x = z2;
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        this.f14526p.setCallback(this);
        this.f14521C = lottieComposition;
        LottieDrawable lottieDrawable = this.f14526p;
        if (lottieDrawable.f2370k != lottieComposition) {
            lottieDrawable.f2368C = false;
            lottieDrawable.m683c();
            lottieDrawable.f2370k = lottieComposition;
            lottieDrawable.m682b();
            LottieValueAnimator lottieValueAnimator = lottieDrawable.f2371l;
            z = lottieValueAnimator.f2304s == null;
            lottieValueAnimator.f2304s = lottieComposition;
            if (z) {
                lottieValueAnimator.m650o((int) Math.max(lottieValueAnimator.f2302q, lottieComposition.f2346k), (int) Math.min(lottieValueAnimator.f2303r, lottieComposition.f2347l));
            } else {
                lottieValueAnimator.m650o((int) lottieComposition.f2346k, (int) lottieComposition.f2347l);
            }
            float f = lottieValueAnimator.f2300o;
            lottieValueAnimator.f2300o = 0.0f;
            lottieValueAnimator.m649n((int) f);
            lottieValueAnimator.m638f();
            lottieDrawable.m701u(lottieDrawable.f2371l.getAnimatedFraction());
            lottieDrawable.f2372m = lottieDrawable.f2372m;
            lottieDrawable.m702v();
            lottieDrawable.m702v();
            Iterator it = new ArrayList(lottieDrawable.f2375p).iterator();
            while (it.hasNext()) {
                ((LottieDrawable.o) it.next()).mo703a(lottieComposition);
                it.remove();
            }
            lottieDrawable.f2375p.clear();
            lottieComposition.f2336a.f2458a = lottieDrawable.f2385z;
            Drawable.Callback callback = lottieDrawable.getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(lottieDrawable);
            }
            z = true;
        }
        m7492b();
        if (getDrawable() != this.f14526p || z) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<LottieOnCompositionLoadedListener> it2 = this.f14536z.iterator();
            while (it2.hasNext()) {
                it2.next().m704a(lottieComposition);
            }
        }
    }

    public void setFailureListener(@Nullable LottieListener<Throwable> lottieListener) {
        this.f14524n = lottieListener;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.f14525o = i;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        FontAssetManager fontAssetManager = this.f14526p.f2381v;
    }

    public void setFrame(int i) {
        this.f14526p.m692l(i);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        LottieDrawable lottieDrawable = this.f14526p;
        lottieDrawable.f2380u = imageAssetDelegate;
        ImageAssetManager imageAssetManager = lottieDrawable.f2378s;
        if (imageAssetManager != null) {
            imageAssetManager.f2650d = imageAssetDelegate;
        }
    }

    public void setImageAssetsFolder(String str) {
        this.f14526p.f2379t = str;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m7491a();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        m7491a();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        m7491a();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.f14526p.m693m(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        this.f14526p.m695o(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.f14526p.m697q(str);
    }

    public void setMinFrame(int i) {
        this.f14526p.m698r(i);
    }

    public void setMinProgress(float f) {
        this.f14526p.m700t(f);
    }

    public void setPerformanceTrackingEnabled(boolean z2) {
        LottieDrawable lottieDrawable = this.f14526p;
        lottieDrawable.f2385z = z2;
        LottieComposition lottieComposition = lottieDrawable.f2370k;
        if (lottieComposition != null) {
            lottieComposition.f2336a.f2458a = z2;
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        this.f14526p.m701u(f);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f14535y = renderMode;
        m7492b();
    }

    public void setRepeatCount(int i) {
        this.f14526p.f2371l.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.f14526p.f2371l.setRepeatMode(i);
    }

    public void setSafeMode(boolean z2) {
        this.f14526p.f2374o = z2;
    }

    public void setScale(float f) {
        LottieDrawable lottieDrawable = this.f14526p;
        lottieDrawable.f2372m = f;
        lottieDrawable.m702v();
        if (getDrawable() == this.f14526p) {
            setImageDrawable(null);
            setImageDrawable(this.f14526p);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        LottieDrawable lottieDrawable = this.f14526p;
        if (lottieDrawable != null) {
            lottieDrawable.f2377r = scaleType;
        }
    }

    public void setSpeed(float f) {
        this.f14526p.f2371l.f2297l = f;
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        Objects.requireNonNull(this.f14526p);
    }

    public void setMaxFrame(String str) {
        this.f14526p.m694n(str);
    }

    public void setMinFrame(String str) {
        this.f14526p.m699s(str);
    }

    public void setAnimation(String str) {
        LottieTask2<LottieComposition> lottieTask2M674a;
        this.f14528r = str;
        this.f14529s = 0;
        if (this.f14534x) {
            Context context = getContext();
            Map<String, LottieTask2<LottieComposition>> map = LottieCompositionFactory.f2351a;
            String strM883w = outline.m883w("asset_", str);
            lottieTask2M674a = LottieCompositionFactory.m674a(strM883w, new LottieCompositionFactory3(context.getApplicationContext(), str, strM883w));
        } else {
            Context context2 = getContext();
            Map<String, LottieTask2<LottieComposition>> map2 = LottieCompositionFactory.f2351a;
            lottieTask2M674a = LottieCompositionFactory.m674a(null, new LottieCompositionFactory3(context2.getApplicationContext(), str, null));
        }
        setCompositionTask(lottieTask2M674a);
    }
}
