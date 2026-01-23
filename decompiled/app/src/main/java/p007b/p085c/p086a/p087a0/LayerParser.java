package p007b.p085c.p086a.p087a0;

import android.graphics.Color;
import java.io.IOException;
import java.util.ArrayList;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.p096k.AnimatableColorValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableIntegerValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableShapeValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableTextFrame;
import p007b.p085c.p086a.p095y.p096k.AnimatableTextProperties;
import p007b.p085c.p086a.p095y.p096k.AnimatableTransform;
import p007b.p085c.p086a.p095y.p097l.ContentModel2;
import p007b.p085c.p086a.p095y.p097l.Mask;
import p007b.p085c.p086a.p095y.p098m.Layer2;

/* JADX INFO: renamed from: b.c.a.a0.s, reason: use source file name */
/* JADX INFO: compiled from: LayerParser.java */
/* JADX INFO: loaded from: classes.dex */
public class LayerParser {

    /* JADX INFO: renamed from: a */
    public static final JsonReader2.a f2280a = JsonReader2.a.m616a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* JADX INFO: renamed from: b */
    public static final JsonReader2.a f2281b = JsonReader2.a.m616a("d", "a");

    /* JADX INFO: renamed from: c */
    public static final JsonReader2.a f2282c = JsonReader2.a.m616a("nm");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0055. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02e4  */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Layer2 m634a(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str;
        String str2;
        long j;
        byte b2;
        byte b3;
        String str3;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader2.mo604b();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        int i = 1;
        boolean z2 = false;
        long jMo610q = -1;
        float fMo609n = 0.0f;
        String strMo612t = null;
        Layer2.a aVar = null;
        String strMo612t2 = null;
        AnimatableTransform animatableTransformM414a = null;
        int iM659c = 0;
        int iM659c2 = 0;
        int color = 0;
        float fMo609n2 = 1.0f;
        float fMo609n3 = 0.0f;
        int iM659c3 = 0;
        int iM659c4 = 0;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        int i2 = 1;
        AnimatableFloatValue animatableFloatValueM565r1 = null;
        boolean zMo608f = false;
        long jMo610q2 = 0;
        String strMo612t3 = "UNSET";
        float fMo609n4 = 0.0f;
        while (jsonReader2.mo607e()) {
            switch (jsonReader2.mo615y(f2280a)) {
                case 0:
                    str2 = strMo612t;
                    strMo612t3 = jsonReader2.mo612t();
                    strMo612t = str2;
                    break;
                case 1:
                    str2 = strMo612t;
                    jMo610q2 = jsonReader2.mo610q();
                    strMo612t = str2;
                    break;
                case 2:
                    str2 = strMo612t;
                    strMo612t2 = jsonReader2.mo612t();
                    strMo612t = str2;
                    break;
                case 3:
                    str2 = strMo612t;
                    j = jMo610q2;
                    int iMo610q = jsonReader2.mo610q();
                    aVar = iMo610q < 6 ? Layer2.a.values()[iMo610q] : Layer2.a.UNKNOWN;
                    jMo610q2 = j;
                    strMo612t = str2;
                    break;
                case 4:
                    str2 = strMo612t;
                    j = jMo610q2;
                    jMo610q = jsonReader2.mo610q();
                    jMo610q2 = j;
                    strMo612t = str2;
                    break;
                case 5:
                    str2 = strMo612t;
                    iM659c = (int) (Utils.m659c() * jsonReader2.mo610q());
                    strMo612t = str2;
                    break;
                case 6:
                    str2 = strMo612t;
                    iM659c2 = (int) (Utils.m659c() * jsonReader2.mo610q());
                    strMo612t = str2;
                    break;
                case 7:
                    str2 = strMo612t;
                    color = Color.parseColor(jsonReader2.mo612t());
                    strMo612t = str2;
                    break;
                case 8:
                    str2 = strMo612t;
                    animatableTransformM414a = AnimatableTransformParser.m414a(jsonReader2, lottieComposition);
                    strMo612t = str2;
                    break;
                case 9:
                    str2 = strMo612t;
                    j = jMo610q2;
                    i2 = C1563b.com$airbnb$lottie$model$layer$Layer$MatteType$s$values()[jsonReader2.mo610q()];
                    lottieComposition.f2350o++;
                    jMo610q2 = j;
                    strMo612t = str2;
                    break;
                case 10:
                    str2 = strMo612t;
                    AnimatableShapeValue animatableShapeValue = null;
                    jsonReader2.mo603a();
                    while (jsonReader2.mo607e()) {
                        jsonReader2.mo604b();
                        AnimatableShapeValue animatableShapeValue2 = animatableShapeValue;
                        AnimatableIntegerValue animatableIntegerValueM569s1 = animatableShapeValue2;
                        int i3 = 0;
                        boolean zMo608f2 = false;
                        while (jsonReader2.mo607e()) {
                            String strMo611s = jsonReader2.mo611s();
                            strMo611s.hashCode();
                            long j2 = jMo610q2;
                            int iHashCode = strMo611s.hashCode();
                            if (iHashCode != 111) {
                                if (iHashCode != 3588) {
                                    if (iHashCode != 104433) {
                                        b2 = (iHashCode == 3357091 && strMo611s.equals("mode")) ? (byte) 3 : (byte) -1;
                                    } else if (strMo611s.equals("inv")) {
                                        b2 = 2;
                                    }
                                } else if (strMo611s.equals("pt")) {
                                    b2 = 1;
                                }
                            } else if (strMo611s.equals("o")) {
                                b2 = 0;
                            }
                            if (b2 == 0) {
                                animatableIntegerValueM569s1 = AnimatableValueParser.m569s1(jsonReader2, lottieComposition);
                            } else if (b2 == 1) {
                                animatableShapeValue2 = new AnimatableShapeValue(KeyframesParser.m632a(jsonReader2, lottieComposition, Utils.m659c(), ShapeDataParser.f2211a));
                            } else if (b2 == 2) {
                                zMo608f2 = jsonReader2.mo608f();
                            } else if (b2 != 3) {
                                jsonReader2.mo601C();
                            } else {
                                String strMo612t4 = jsonReader2.mo612t();
                                strMo612t4.hashCode();
                                int iHashCode2 = strMo612t4.hashCode();
                                if (iHashCode2 == 97) {
                                    if (strMo612t4.equals("a")) {
                                        b3 = 0;
                                    }
                                    if (b3 != 0) {
                                    }
                                    i3 = 1;
                                } else if (iHashCode2 == 105) {
                                    if (strMo612t4.equals("i")) {
                                        b3 = 1;
                                    }
                                    if (b3 != 0) {
                                    }
                                    i3 = 1;
                                } else if (iHashCode2 != 110) {
                                    b3 = (iHashCode2 == 115 && strMo612t4.equals("s")) ? (byte) 3 : (byte) -1;
                                    if (b3 != 0) {
                                        if (b3 == 1) {
                                            lottieComposition.m669a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                            i3 = 3;
                                        } else if (b3 == 2) {
                                            i3 = 4;
                                        } else if (b3 != 3) {
                                            Logger2.m640b("Unknown mask mode " + strMo611s + ". Defaulting to Add.");
                                        } else {
                                            i3 = 2;
                                        }
                                    }
                                    i3 = 1;
                                } else {
                                    if (strMo612t4.equals("n")) {
                                        b3 = 2;
                                    }
                                    if (b3 != 0) {
                                    }
                                    i3 = 1;
                                }
                            }
                            jMo610q2 = j2;
                            animatableIntegerValueM569s1 = animatableIntegerValueM569s1;
                        }
                        jsonReader2.mo606d();
                        arrayList3.add(new Mask(i3, animatableShapeValue2, animatableIntegerValueM569s1, zMo608f2));
                        jMo610q2 = jMo610q2;
                        animatableShapeValue = null;
                    }
                    j = jMo610q2;
                    lottieComposition.f2350o += arrayList3.size();
                    jsonReader2.mo605c();
                    jMo610q2 = j;
                    strMo612t = str2;
                    break;
                case 11:
                    str2 = strMo612t;
                    jsonReader2.mo603a();
                    while (jsonReader2.mo607e()) {
                        ContentModel2 contentModel2M599a = ContentModelParser.m599a(jsonReader2, lottieComposition);
                        if (contentModel2M599a != null) {
                            arrayList4.add(contentModel2M599a);
                        }
                    }
                    jsonReader2.mo605c();
                    j = jMo610q2;
                    jMo610q2 = j;
                    strMo612t = str2;
                    break;
                case 12:
                    jsonReader2.mo604b();
                    while (jsonReader2.mo607e()) {
                        int iMo615y = jsonReader2.mo615y(f2281b);
                        if (iMo615y == 0) {
                            str3 = strMo612t;
                            animatableTextFrame = new AnimatableTextFrame(AnimatableValueParser.m553o1(jsonReader2, lottieComposition, DocumentDataParser.f2233a));
                        } else if (iMo615y != i) {
                            jsonReader2.mo600A();
                            jsonReader2.mo601C();
                        } else {
                            jsonReader2.mo603a();
                            if (jsonReader2.mo607e()) {
                                JsonReader2.a aVar2 = AnimatableTextPropertiesParser.f2209a;
                                jsonReader2.mo604b();
                                AnimatableTextProperties animatableTextProperties2 = null;
                                while (jsonReader2.mo607e()) {
                                    if (jsonReader2.mo615y(AnimatableTextPropertiesParser.f2209a) != 0) {
                                        jsonReader2.mo600A();
                                        jsonReader2.mo601C();
                                    } else {
                                        jsonReader2.mo604b();
                                        AnimatableFloatValue animatableFloatValueM561q1 = null;
                                        AnimatableFloatValue animatableFloatValueM561q12 = null;
                                        AnimatableColorValue animatableColorValueM557p1 = null;
                                        AnimatableColorValue animatableColorValueM557p12 = null;
                                        while (jsonReader2.mo607e()) {
                                            int iMo615y2 = jsonReader2.mo615y(AnimatableTextPropertiesParser.f2210b);
                                            if (iMo615y2 == 0) {
                                                animatableColorValueM557p1 = AnimatableValueParser.m557p1(jsonReader2, lottieComposition);
                                            } else if (iMo615y2 == i) {
                                                animatableColorValueM557p12 = AnimatableValueParser.m557p1(jsonReader2, lottieComposition);
                                            } else if (iMo615y2 == 2) {
                                                animatableFloatValueM561q1 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
                                            } else if (iMo615y2 != 3) {
                                                jsonReader2.mo600A();
                                                jsonReader2.mo601C();
                                            } else {
                                                animatableFloatValueM561q12 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
                                            }
                                            i = 1;
                                        }
                                        jsonReader2.mo606d();
                                        animatableTextProperties2 = new AnimatableTextProperties(animatableColorValueM557p1, animatableColorValueM557p12, animatableFloatValueM561q1, animatableFloatValueM561q12);
                                        strMo612t = strMo612t;
                                        i = 1;
                                    }
                                }
                                str3 = strMo612t;
                                jsonReader2.mo606d();
                                animatableTextProperties = animatableTextProperties2 == null ? new AnimatableTextProperties(null, null, null, null) : animatableTextProperties2;
                            } else {
                                str3 = strMo612t;
                            }
                            while (jsonReader2.mo607e()) {
                                jsonReader2.mo601C();
                            }
                            jsonReader2.mo605c();
                        }
                        strMo612t = str3;
                        i = 1;
                    }
                    str2 = strMo612t;
                    jsonReader2.mo606d();
                    strMo612t = str2;
                    break;
                case 13:
                    jsonReader2.mo603a();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader2.mo607e()) {
                        jsonReader2.mo604b();
                        while (jsonReader2.mo607e()) {
                            if (jsonReader2.mo615y(f2282c) != 0) {
                                jsonReader2.mo600A();
                                jsonReader2.mo601C();
                            } else {
                                arrayList5.add(jsonReader2.mo612t());
                            }
                        }
                        jsonReader2.mo606d();
                    }
                    jsonReader2.mo605c();
                    lottieComposition.m669a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    str2 = strMo612t;
                    j = jMo610q2;
                    jMo610q2 = j;
                    strMo612t = str2;
                    break;
                case 14:
                    fMo609n2 = (float) jsonReader2.mo609n();
                    str2 = strMo612t;
                    strMo612t = str2;
                    break;
                case 15:
                    fMo609n3 = (float) jsonReader2.mo609n();
                    str2 = strMo612t;
                    strMo612t = str2;
                    break;
                case 16:
                    iM659c3 = (int) (Utils.m659c() * jsonReader2.mo610q());
                    str2 = strMo612t;
                    strMo612t = str2;
                    break;
                case 17:
                    iM659c4 = (int) (Utils.m659c() * jsonReader2.mo610q());
                    str2 = strMo612t;
                    strMo612t = str2;
                    break;
                case 18:
                    fMo609n = (float) jsonReader2.mo609n();
                    str2 = strMo612t;
                    strMo612t = str2;
                    break;
                case 19:
                    fMo609n4 = (float) jsonReader2.mo609n();
                    break;
                case 20:
                    animatableFloatValueM565r1 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, z2);
                    break;
                case 21:
                    strMo612t = jsonReader2.mo612t();
                    break;
                case 22:
                    zMo608f = jsonReader2.mo608f();
                    break;
                default:
                    str2 = strMo612t;
                    j = jMo610q2;
                    jsonReader2.mo600A();
                    jsonReader2.mo601C();
                    jMo610q2 = j;
                    strMo612t = str2;
                    break;
            }
            i = 1;
            z2 = false;
        }
        String str4 = strMo612t;
        long j3 = jMo610q2;
        jsonReader2.mo606d();
        float f = fMo609n / fMo609n2;
        float f2 = fMo609n4 / fMo609n2;
        ArrayList arrayList6 = new ArrayList();
        if (f > 0.0f) {
            arrayList = arrayList4;
            arrayList2 = arrayList3;
            str = str4;
            arrayList6.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f)));
        } else {
            arrayList = arrayList4;
            arrayList2 = arrayList3;
            str = str4;
        }
        if (f2 <= 0.0f) {
            f2 = lottieComposition.f2347l;
        }
        arrayList6.add(new Keyframe(lottieComposition, fValueOf, fValueOf, null, f, Float.valueOf(f2)));
        arrayList6.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, f2, Float.valueOf(Float.MAX_VALUE)));
        if (strMo612t3.endsWith(".ai") || "ai".equals(str)) {
            lottieComposition.m669a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer2(arrayList, lottieComposition, strMo612t3, j3, aVar, jMo610q, strMo612t2, arrayList2, animatableTransformM414a, iM659c, iM659c2, color, fMo609n2, fMo609n3, iM659c3, iM659c4, animatableTextFrame, animatableTextProperties, arrayList6, i2, animatableFloatValueM565r1, zMo608f);
    }
}
