package p007b.p085c.p086a.p095y.p098m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.p092b.ContentGroup;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.TextKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ValueCallbackKeyframeAnimation;
import p007b.p085c.p086a.p094x.FontAssetManager;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.DocumentData;
import p007b.p085c.p086a.p095y.Font;
import p007b.p085c.p086a.p095y.FontCharacter;
import p007b.p085c.p086a.p095y.MutablePair;
import p007b.p085c.p086a.p095y.p096k.AnimatableColorValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableTextProperties;
import p007b.p085c.p086a.p095y.p097l.ShapeGroup;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: TextLayer.java */
/* renamed from: b.c.a.y.m.i, reason: use source file name */
/* loaded from: classes.dex */
public class TextLayer extends BaseLayer2 {

    /* renamed from: A */
    public final Paint f2905A;

    /* renamed from: B */
    public final Paint f2906B;

    /* renamed from: C */
    public final Map<FontCharacter, List<ContentGroup>> f2907C;

    /* renamed from: D */
    public final LongSparseArray<String> f2908D;

    /* renamed from: E */
    public final TextKeyframeAnimation f2909E;

    /* renamed from: F */
    public final LottieDrawable f2910F;

    /* renamed from: G */
    public final LottieComposition f2911G;

    /* renamed from: H */
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> f2912H;

    /* renamed from: I */
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> f2913I;

    /* renamed from: J */
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> f2914J;

    /* renamed from: K */
    @Nullable
    public BaseKeyframeAnimation<Integer, Integer> f2915K;

    /* renamed from: L */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f2916L;

    /* renamed from: M */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f2917M;

    /* renamed from: N */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f2918N;

    /* renamed from: O */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f2919O;

    /* renamed from: P */
    @Nullable
    public BaseKeyframeAnimation<Float, Float> f2920P;

    /* renamed from: x */
    public final StringBuilder f2921x;

    /* renamed from: y */
    public final RectF f2922y;

    /* renamed from: z */
    public final Matrix f2923z;

    /* compiled from: TextLayer.java */
    /* renamed from: b.c.a.y.m.i$a */
    public class a extends Paint {
        public a(TextLayer textLayer, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    /* renamed from: b.c.a.y.m.i$b */
    public class b extends Paint {
        public b(TextLayer textLayer, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    public TextLayer(LottieDrawable lottieDrawable, Layer2 layer2) {
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableColorValue animatableColorValue;
        AnimatableColorValue animatableColorValue2;
        super(lottieDrawable, layer2);
        this.f2921x = new StringBuilder(2);
        this.f2922y = new RectF();
        this.f2923z = new Matrix();
        this.f2905A = new a(this, 1);
        this.f2906B = new b(this, 1);
        this.f2907C = new HashMap();
        this.f2908D = new LongSparseArray<>();
        this.f2910F = lottieDrawable;
        this.f2911G = layer2.f2869b;
        TextKeyframeAnimation textKeyframeAnimation = new TextKeyframeAnimation(layer2.f2884q.f2738a);
        this.f2909E = textKeyframeAnimation;
        textKeyframeAnimation.f2596a.add(this);
        m777e(textKeyframeAnimation);
        AnimatableTextProperties animatableTextProperties = layer2.f2885r;
        if (animatableTextProperties != null && (animatableColorValue2 = animatableTextProperties.f2725a) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationMo773a = animatableColorValue2.mo773a();
            this.f2912H = baseKeyframeAnimationMo773a;
            baseKeyframeAnimationMo773a.f2596a.add(this);
            m777e(this.f2912H);
        }
        if (animatableTextProperties != null && (animatableColorValue = animatableTextProperties.f2726b) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationMo773a2 = animatableColorValue.mo773a();
            this.f2914J = baseKeyframeAnimationMo773a2;
            baseKeyframeAnimationMo773a2.f2596a.add(this);
            m777e(this.f2914J);
        }
        if (animatableTextProperties != null && (animatableFloatValue2 = animatableTextProperties.f2727c) != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a3 = animatableFloatValue2.mo773a();
            this.f2916L = baseKeyframeAnimationMo773a3;
            baseKeyframeAnimationMo773a3.f2596a.add(this);
            m777e(this.f2916L);
        }
        if (animatableTextProperties == null || (animatableFloatValue = animatableTextProperties.f2728d) == null) {
            return;
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a4 = animatableFloatValue.mo773a();
        this.f2918N = baseKeyframeAnimationMo773a4;
        baseKeyframeAnimationMo773a4.f2596a.add(this);
        m777e(this.f2918N);
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2, p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        super.mo712d(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, this.f2911G.f2345j.width(), this.f2911G.f2345j.height());
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2, p007b.p085c.p086a.p095y.KeyPathElement
    /* renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.f2857v.m745c(t, lottieValueCallback);
        if (t == LottieProperty.f2423a) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f2913I;
            if (baseKeyframeAnimation != null) {
                this.f2856u.remove(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f2913I = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2913I = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.f2596a.add(this);
            m777e(this.f2913I);
            return;
        }
        if (t == LottieProperty.f2424b) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f2915K;
            if (baseKeyframeAnimation2 != null) {
                this.f2856u.remove(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.f2915K = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2915K = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.f2596a.add(this);
            m777e(this.f2915K);
            return;
        }
        if (t == LottieProperty.f2437o) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.f2917M;
            if (baseKeyframeAnimation3 != null) {
                this.f2856u.remove(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.f2917M = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2917M = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.f2596a.add(this);
            m777e(this.f2917M);
            return;
        }
        if (t == LottieProperty.f2438p) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.f2919O;
            if (baseKeyframeAnimation4 != null) {
                this.f2856u.remove(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.f2919O = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2919O = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.f2596a.add(this);
            m777e(this.f2919O);
            return;
        }
        if (t == LottieProperty.f2420B) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.f2920P;
            if (baseKeyframeAnimation5 != null) {
                this.f2856u.remove(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.f2920P = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2920P = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.f2596a.add(this);
            m777e(this.f2920P);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Object, java.lang.String] */
    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2
    /* renamed from: j */
    public void mo780j(Canvas canvas, Matrix matrix, int i) {
        FontAssetManager fontAssetManager;
        String str;
        float fFloatValue;
        List<String> list;
        int i2;
        String str2;
        List<ContentGroup> list2;
        float fFloatValue2;
        String str3;
        float f;
        int i3;
        canvas.save();
        if (!(this.f2910F.f2370k.f2342g.size() > 0)) {
            canvas.setMatrix(matrix);
        }
        DocumentData documentDataMo727e = this.f2909E.mo727e();
        Font font = this.f2911G.f2340e.get(documentDataMo727e.f2694b);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f2913I;
        if (baseKeyframeAnimation != null) {
            this.f2905A.setColor(baseKeyframeAnimation.mo727e().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f2912H;
            if (baseKeyframeAnimation2 != null) {
                this.f2905A.setColor(baseKeyframeAnimation2.mo727e().intValue());
            } else {
                this.f2905A.setColor(documentDataMo727e.f2700h);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.f2915K;
        if (baseKeyframeAnimation3 != null) {
            this.f2906B.setColor(baseKeyframeAnimation3.mo727e().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.f2914J;
            if (baseKeyframeAnimation4 != null) {
                this.f2906B.setColor(baseKeyframeAnimation4.mo727e().intValue());
            } else {
                this.f2906B.setColor(documentDataMo727e.f2701i);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation5 = this.f2857v.f2636j;
        int iIntValue = ((baseKeyframeAnimation5 == null ? 100 : baseKeyframeAnimation5.mo727e().intValue()) * 255) / 100;
        this.f2905A.setAlpha(iIntValue);
        this.f2906B.setAlpha(iIntValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.f2917M;
        if (baseKeyframeAnimation6 != null) {
            this.f2906B.setStrokeWidth(baseKeyframeAnimation6.mo727e().floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.f2916L;
            if (baseKeyframeAnimation7 != null) {
                this.f2906B.setStrokeWidth(baseKeyframeAnimation7.mo727e().floatValue());
            } else {
                this.f2906B.setStrokeWidth(Utils.m659c() * documentDataMo727e.f2702j * Utils.m660d(matrix));
            }
        }
        if (this.f2910F.f2370k.f2342g.size() > 0) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation8 = this.f2920P;
            float fFloatValue3 = (baseKeyframeAnimation8 != null ? baseKeyframeAnimation8.mo727e().floatValue() : documentDataMo727e.f2695c) / 100.0f;
            float fM660d = Utils.m660d(matrix);
            String str4 = documentDataMo727e.f2693a;
            float fM659c = Utils.m659c() * documentDataMo727e.f2698f;
            List<String> listM792t = m792t(str4);
            int size = listM792t.size();
            int i4 = 0;
            while (i4 < size) {
                String str5 = listM792t.get(i4);
                float fM659c2 = 0.0f;
                int i5 = 0;
                while (i5 < str5.length()) {
                    FontCharacter fontCharacter = this.f2911G.f2342g.get(FontCharacter.m765a(str5.charAt(i5), font.f2704a, font.f2706c));
                    if (fontCharacter == null) {
                        f = fM659c;
                        i3 = i4;
                        str3 = str5;
                    } else {
                        str3 = str5;
                        double d = fontCharacter.f2709c;
                        f = fM659c;
                        i3 = i4;
                        fM659c2 = (float) ((d * fFloatValue3 * Utils.m659c() * fM660d) + fM659c2);
                    }
                    i5++;
                    str5 = str3;
                    fM659c = f;
                    i4 = i3;
                }
                float f2 = fM659c;
                int i6 = i4;
                String str6 = str5;
                canvas.save();
                m789q(documentDataMo727e.f2696d, canvas, fM659c2);
                canvas.translate(0.0f, (i6 * f2) - (((size - 1) * f2) / 2.0f));
                int i7 = 0;
                while (i7 < str6.length()) {
                    String str7 = str6;
                    FontCharacter fontCharacter2 = this.f2911G.f2342g.get(FontCharacter.m765a(str7.charAt(i7), font.f2704a, font.f2706c));
                    if (fontCharacter2 == null) {
                        list = listM792t;
                        i2 = size;
                        str2 = str7;
                    } else {
                        if (this.f2907C.containsKey(fontCharacter2)) {
                            list2 = this.f2907C.get(fontCharacter2);
                            list = listM792t;
                            i2 = size;
                            str2 = str7;
                        } else {
                            List<ShapeGroup> list3 = fontCharacter2.f2707a;
                            int size2 = list3.size();
                            ArrayList arrayList = new ArrayList(size2);
                            list = listM792t;
                            int i8 = 0;
                            while (i8 < size2) {
                                arrayList.add(new ContentGroup(this.f2910F, this, list3.get(i8)));
                                i8++;
                                str7 = str7;
                                size = size;
                                list3 = list3;
                            }
                            i2 = size;
                            str2 = str7;
                            this.f2907C.put(fontCharacter2, arrayList);
                            list2 = arrayList;
                        }
                        int i9 = 0;
                        while (i9 < list2.size()) {
                            Path path = list2.get(i9).getPath();
                            path.computeBounds(this.f2922y, false);
                            this.f2923z.set(matrix);
                            List<ContentGroup> list4 = list2;
                            this.f2923z.preTranslate(0.0f, (-documentDataMo727e.f2699g) * Utils.m659c());
                            this.f2923z.preScale(fFloatValue3, fFloatValue3);
                            path.transform(this.f2923z);
                            if (documentDataMo727e.f2703k) {
                                m791s(path, this.f2905A, canvas);
                                m791s(path, this.f2906B, canvas);
                            } else {
                                m791s(path, this.f2906B, canvas);
                                m791s(path, this.f2905A, canvas);
                            }
                            i9++;
                            list2 = list4;
                        }
                        float fM659c3 = Utils.m659c() * ((float) fontCharacter2.f2709c) * fFloatValue3 * fM660d;
                        float f3 = documentDataMo727e.f2697e / 10.0f;
                        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation9 = this.f2919O;
                        if (baseKeyframeAnimation9 != null) {
                            fFloatValue2 = baseKeyframeAnimation9.mo727e().floatValue();
                        } else {
                            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation10 = this.f2918N;
                            if (baseKeyframeAnimation10 != null) {
                                fFloatValue2 = baseKeyframeAnimation10.mo727e().floatValue();
                            }
                            canvas.translate((f3 * fM660d) + fM659c3, 0.0f);
                        }
                        f3 += fFloatValue2;
                        canvas.translate((f3 * fM660d) + fM659c3, 0.0f);
                    }
                    i7++;
                    listM792t = list;
                    str6 = str2;
                    size = i2;
                }
                canvas.restore();
                i4 = i6 + 1;
                fM659c = f2;
            }
        } else {
            float fM660d2 = Utils.m660d(matrix);
            LottieDrawable lottieDrawable = this.f2910F;
            ?? r6 = font.f2704a;
            ?? r3 = font.f2706c;
            Typeface typefaceCreate = null;
            if (lottieDrawable.getCallback() == null) {
                fontAssetManager = null;
            } else {
                if (lottieDrawable.f2381v == null) {
                    lottieDrawable.f2381v = new FontAssetManager(lottieDrawable.getCallback());
                }
                fontAssetManager = lottieDrawable.f2381v;
            }
            if (fontAssetManager != null) {
                MutablePair<String> mutablePair = fontAssetManager.f2642a;
                mutablePair.f2720a = r6;
                mutablePair.f2721b = r3;
                typefaceCreate = fontAssetManager.f2643b.get(mutablePair);
                if (typefaceCreate == null) {
                    Typeface typefaceCreateFromAsset = fontAssetManager.f2644c.get(r6);
                    if (typefaceCreateFromAsset == null) {
                        StringBuilder sbM836X = outline.m836X("fonts/", r6);
                        sbM836X.append(fontAssetManager.f2646e);
                        typefaceCreateFromAsset = Typeface.createFromAsset(fontAssetManager.f2645d, sbM836X.toString());
                        fontAssetManager.f2644c.put(r6, typefaceCreateFromAsset);
                    }
                    boolean zContains = r3.contains("Italic");
                    boolean zContains2 = r3.contains("Bold");
                    int i10 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
                    typefaceCreate = typefaceCreateFromAsset.getStyle() == i10 ? typefaceCreateFromAsset : Typeface.create(typefaceCreateFromAsset, i10);
                    fontAssetManager.f2643b.put(fontAssetManager.f2642a, typefaceCreate);
                }
            }
            if (typefaceCreate != null) {
                String str8 = documentDataMo727e.f2693a;
                Objects.requireNonNull(this.f2910F);
                this.f2905A.setTypeface(typefaceCreate);
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation11 = this.f2920P;
                this.f2905A.setTextSize(Utils.m659c() * (baseKeyframeAnimation11 != null ? baseKeyframeAnimation11.mo727e().floatValue() : documentDataMo727e.f2695c));
                this.f2906B.setTypeface(this.f2905A.getTypeface());
                this.f2906B.setTextSize(this.f2905A.getTextSize());
                float fM659c4 = Utils.m659c() * documentDataMo727e.f2698f;
                List<String> listM792t2 = m792t(str8);
                int size3 = listM792t2.size();
                for (int i11 = 0; i11 < size3; i11++) {
                    String str9 = listM792t2.get(i11);
                    m789q(documentDataMo727e.f2696d, canvas, this.f2906B.measureText(str9));
                    canvas.translate(0.0f, (i11 * fM659c4) - (((size3 - 1) * fM659c4) / 2.0f));
                    int length = 0;
                    while (length < str9.length()) {
                        int iCodePointAt = str9.codePointAt(length);
                        int iCharCount = Character.charCount(iCodePointAt) + length;
                        while (iCharCount < str9.length()) {
                            int iCodePointAt2 = str9.codePointAt(iCharCount);
                            if (!(Character.getType(iCodePointAt2) == 16 || Character.getType(iCodePointAt2) == 27 || Character.getType(iCodePointAt2) == 6 || Character.getType(iCodePointAt2) == 28 || Character.getType(iCodePointAt2) == 19)) {
                                break;
                            }
                            iCharCount += Character.charCount(iCodePointAt2);
                            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
                        }
                        int i12 = size3;
                        float f4 = fM659c4;
                        long j = iCodePointAt;
                        if (this.f2908D.containsKey(j)) {
                            str = this.f2908D.get(j);
                        } else {
                            this.f2921x.setLength(0);
                            int iCharCount2 = length;
                            while (iCharCount2 < iCharCount) {
                                int iCodePointAt3 = str9.codePointAt(iCharCount2);
                                this.f2921x.appendCodePoint(iCodePointAt3);
                                iCharCount2 += Character.charCount(iCodePointAt3);
                            }
                            String string = this.f2921x.toString();
                            this.f2908D.put(j, string);
                            str = string;
                        }
                        length += str.length();
                        if (documentDataMo727e.f2703k) {
                            m790r(str, this.f2905A, canvas);
                            m790r(str, this.f2906B, canvas);
                        } else {
                            m790r(str, this.f2906B, canvas);
                            m790r(str, this.f2905A, canvas);
                        }
                        float fMeasureText = this.f2905A.measureText(str, 0, 1);
                        float f5 = documentDataMo727e.f2697e / 10.0f;
                        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation12 = this.f2919O;
                        if (baseKeyframeAnimation12 != null) {
                            fFloatValue = baseKeyframeAnimation12.mo727e().floatValue();
                        } else {
                            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation13 = this.f2918N;
                            if (baseKeyframeAnimation13 != null) {
                                fFloatValue = baseKeyframeAnimation13.mo727e().floatValue();
                            } else {
                                canvas.translate((f5 * fM660d2) + fMeasureText, 0.0f);
                                fM659c4 = f4;
                                size3 = i12;
                            }
                        }
                        f5 += fFloatValue;
                        canvas.translate((f5 * fM660d2) + fMeasureText, 0.0f);
                        fM659c4 = f4;
                        size3 = i12;
                    }
                    canvas.setMatrix(matrix);
                }
            }
        }
        canvas.restore();
    }

    /* renamed from: q */
    public final void m789q(int i, Canvas canvas, float f) {
        int iM758h = C1563b.m758h(i);
        if (iM758h == 1) {
            canvas.translate(-f, 0.0f);
        } else {
            if (iM758h != 2) {
                return;
            }
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    /* renamed from: r */
    public final void m790r(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    /* renamed from: s */
    public final void m791s(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    /* renamed from: t */
    public final List<String> m792t(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }
}
