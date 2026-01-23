package p007b.p085c.p086a.p087a0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.p096k.AnimatableColorValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableFloatValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableGradientColorValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableIntegerValue;
import p007b.p085c.p086a.p095y.p096k.AnimatablePointValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableShapeValue;
import p007b.p085c.p086a.p095y.p096k.AnimatableTransform;
import p007b.p085c.p086a.p095y.p096k.AnimatableValue;
import p007b.p085c.p086a.p095y.p097l.CircleShape;
import p007b.p085c.p086a.p095y.p097l.ContentModel2;
import p007b.p085c.p086a.p095y.p097l.GradientFill;
import p007b.p085c.p086a.p095y.p097l.GradientStroke;
import p007b.p085c.p086a.p095y.p097l.MergePaths;
import p007b.p085c.p086a.p095y.p097l.PolystarShape;
import p007b.p085c.p086a.p095y.p097l.RectangleShape;
import p007b.p085c.p086a.p095y.p097l.Repeater;
import p007b.p085c.p086a.p095y.p097l.ShapeFill;
import p007b.p085c.p086a.p095y.p097l.ShapeGroup;
import p007b.p085c.p086a.p095y.p097l.ShapePath2;
import p007b.p085c.p086a.p095y.p097l.ShapeStroke;
import p007b.p085c.p086a.p095y.p097l.ShapeTrimPath;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.c.a.a0.g, reason: use source file name */
/* JADX INFO: compiled from: ContentModelParser.java */
/* JADX INFO: loaded from: classes.dex */
public class ContentModelParser {

    /* JADX INFO: renamed from: a */
    public static JsonReader2.a f2231a = JsonReader2.a.m616a("ty", "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x069f A[LOOP:1: B:386:0x0699->B:388:0x069f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e3  */
    @Nullable
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ContentModel2 m599a(JsonReader2 jsonReader2, LottieComposition lottieComposition) throws IOException {
        String strMo612t;
        String strMo612t2;
        boolean zMo608f;
        ContentModel2 circleShape;
        ContentModel2 shapeGroup;
        boolean zMo608f2;
        String strMo612t3;
        int iMo610q;
        String strMo612t4;
        byte b2;
        jsonReader2.mo604b();
        int iMo610q2 = 2;
        while (true) {
            strMo612t = null;
            circleShape = null;
            strMo612t4 = null;
            strMo612t3 = null;
            if (!jsonReader2.mo607e()) {
                strMo612t2 = null;
                break;
            }
            int iMo615y = jsonReader2.mo615y(f2231a);
            if (iMo615y == 0) {
                strMo612t2 = jsonReader2.mo612t();
                break;
            }
            if (iMo615y != 1) {
                jsonReader2.mo600A();
                jsonReader2.mo601C();
            } else {
                iMo610q2 = jsonReader2.mo610q();
            }
        }
        if (strMo612t2 == null) {
            return null;
        }
        zMo608f = false;
        iMo610q = 0;
        zMo608f2 = false;
        switch (strMo612t2) {
            case "el":
                JsonReader2.a aVar = CircleShapeParser.f2226a;
                boolean z2 = iMo610q2 == 3;
                String strMo612t5 = null;
                AnimatableValue<PointF, PointF> animatableValueM412b = null;
                AnimatablePointValue animatablePointValueM577u1 = null;
                boolean zMo608f3 = false;
                while (jsonReader2.mo607e()) {
                    int iMo615y2 = jsonReader2.mo615y(CircleShapeParser.f2226a);
                    if (iMo615y2 == 0) {
                        strMo612t5 = jsonReader2.mo612t();
                    } else if (iMo615y2 == 1) {
                        animatableValueM412b = AnimatablePathValueParser.m412b(jsonReader2, lottieComposition);
                    } else if (iMo615y2 == 2) {
                        animatablePointValueM577u1 = AnimatableValueParser.m577u1(jsonReader2, lottieComposition);
                    } else if (iMo615y2 == 3) {
                        zMo608f3 = jsonReader2.mo608f();
                    } else if (iMo615y2 != 4) {
                        jsonReader2.mo600A();
                        jsonReader2.mo601C();
                    } else {
                        z2 = jsonReader2.mo610q() == 3;
                    }
                }
                circleShape = new CircleShape(strMo612t5, animatableValueM412b, animatablePointValueM577u1, z2, zMo608f3);
                while (jsonReader2.mo607e()) {
                    jsonReader2.mo601C();
                }
                jsonReader2.mo606d();
                return circleShape;
            case "fl":
                JsonReader2.a aVar2 = ShapeFillParser.f2215a;
                int iMo610q3 = 1;
                String strMo612t6 = null;
                AnimatableColorValue animatableColorValueM557p1 = null;
                AnimatableIntegerValue animatableIntegerValueM569s1 = null;
                boolean zMo608f4 = false;
                boolean zMo608f5 = false;
                while (jsonReader2.mo607e()) {
                    int iMo615y3 = jsonReader2.mo615y(ShapeFillParser.f2215a);
                    if (iMo615y3 == 0) {
                        strMo612t6 = jsonReader2.mo612t();
                    } else if (iMo615y3 == 1) {
                        animatableColorValueM557p1 = AnimatableValueParser.m557p1(jsonReader2, lottieComposition);
                    } else if (iMo615y3 == 2) {
                        animatableIntegerValueM569s1 = AnimatableValueParser.m569s1(jsonReader2, lottieComposition);
                    } else if (iMo615y3 == 3) {
                        zMo608f4 = jsonReader2.mo608f();
                    } else if (iMo615y3 == 4) {
                        iMo610q3 = jsonReader2.mo610q();
                    } else if (iMo615y3 != 5) {
                        jsonReader2.mo600A();
                        jsonReader2.mo601C();
                    } else {
                        zMo608f5 = jsonReader2.mo608f();
                    }
                }
                circleShape = new ShapeFill(strMo612t6, zMo608f4, iMo610q3 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValueM557p1, animatableIntegerValueM569s1, zMo608f5);
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "gf":
                JsonReader2.a aVar3 = GradientFillParser.f2269a;
                Path.FillType fillType = Path.FillType.WINDING;
                String strMo612t7 = null;
                AnimatableGradientColorValue animatableGradientColorValue = null;
                AnimatableIntegerValue animatableIntegerValueM569s12 = null;
                AnimatablePointValue animatablePointValueM577u12 = null;
                AnimatablePointValue animatablePointValueM577u13 = null;
                int i = 0;
                boolean zMo608f6 = false;
                while (jsonReader2.mo607e()) {
                    switch (jsonReader2.mo615y(GradientFillParser.f2269a)) {
                        case 0:
                            strMo612t7 = jsonReader2.mo612t();
                            break;
                        case 1:
                            jsonReader2.mo604b();
                            int iMo610q4 = -1;
                            while (jsonReader2.mo607e()) {
                                int iMo615y4 = jsonReader2.mo615y(GradientFillParser.f2270b);
                                if (iMo615y4 == 0) {
                                    iMo610q4 = jsonReader2.mo610q();
                                } else if (iMo615y4 != 1) {
                                    jsonReader2.mo600A();
                                    jsonReader2.mo601C();
                                } else {
                                    animatableGradientColorValue = new AnimatableGradientColorValue(AnimatableValueParser.m553o1(jsonReader2, lottieComposition, new GradientColorParser(iMo610q4)));
                                }
                            }
                            jsonReader2.mo606d();
                            break;
                        case 2:
                            animatableIntegerValueM569s12 = AnimatableValueParser.m569s1(jsonReader2, lottieComposition);
                            break;
                        case 3:
                            i = jsonReader2.mo610q() != 1 ? 2 : 1;
                            break;
                        case 4:
                            animatablePointValueM577u12 = AnimatableValueParser.m577u1(jsonReader2, lottieComposition);
                            break;
                        case 5:
                            animatablePointValueM577u13 = AnimatableValueParser.m577u1(jsonReader2, lottieComposition);
                            break;
                        case 6:
                            fillType = jsonReader2.mo610q() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                            break;
                        case 7:
                            zMo608f6 = jsonReader2.mo608f();
                            break;
                        default:
                            jsonReader2.mo600A();
                            jsonReader2.mo601C();
                            break;
                    }
                }
                circleShape = new GradientFill(strMo612t7, i, fillType, animatableGradientColorValue, animatableIntegerValueM569s12, animatablePointValueM577u12, animatablePointValueM577u13, null, null, zMo608f6);
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "gr":
                JsonReader2.a aVar4 = ShapeGroupParser.f2225a;
                ArrayList arrayList = new ArrayList();
                while (jsonReader2.mo607e()) {
                    int iMo615y5 = jsonReader2.mo615y(ShapeGroupParser.f2225a);
                    if (iMo615y5 == 0) {
                        strMo612t = jsonReader2.mo612t();
                    } else if (iMo615y5 == 1) {
                        zMo608f = jsonReader2.mo608f();
                    } else if (iMo615y5 != 2) {
                        jsonReader2.mo601C();
                    } else {
                        jsonReader2.mo603a();
                        while (jsonReader2.mo607e()) {
                            ContentModel2 contentModel2M599a = m599a(jsonReader2, lottieComposition);
                            if (contentModel2M599a != null) {
                                arrayList.add(contentModel2M599a);
                            }
                        }
                        jsonReader2.mo605c();
                    }
                }
                shapeGroup = new ShapeGroup(strMo612t, arrayList, zMo608f);
                circleShape = shapeGroup;
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "gs":
                JsonReader2.a aVar5 = GradientStrokeParser.f2271a;
                ArrayList arrayList2 = new ArrayList();
                String strMo612t8 = null;
                AnimatableGradientColorValue animatableGradientColorValue2 = null;
                AnimatableIntegerValue animatableIntegerValueM569s13 = null;
                AnimatablePointValue animatablePointValueM577u14 = null;
                AnimatablePointValue animatablePointValueM577u15 = null;
                AnimatableFloatValue animatableFloatValueM561q1 = null;
                AnimatableFloatValue animatableFloatValue = null;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                float fMo609n = 0.0f;
                boolean zMo608f7 = false;
                while (jsonReader2.mo607e()) {
                    switch (jsonReader2.mo615y(GradientStrokeParser.f2271a)) {
                        case 0:
                            strMo612t8 = jsonReader2.mo612t();
                            break;
                        case 1:
                            jsonReader2.mo604b();
                            int iMo610q5 = -1;
                            while (jsonReader2.mo607e()) {
                                int iMo615y6 = jsonReader2.mo615y(GradientStrokeParser.f2272b);
                                if (iMo615y6 == 0) {
                                    iMo610q5 = jsonReader2.mo610q();
                                } else if (iMo615y6 != 1) {
                                    jsonReader2.mo600A();
                                    jsonReader2.mo601C();
                                } else {
                                    animatableGradientColorValue2 = new AnimatableGradientColorValue(AnimatableValueParser.m553o1(jsonReader2, lottieComposition, new GradientColorParser(iMo610q5)));
                                }
                            }
                            jsonReader2.mo606d();
                            break;
                        case 2:
                            animatableIntegerValueM569s13 = AnimatableValueParser.m569s1(jsonReader2, lottieComposition);
                            break;
                        case 3:
                            i2 = jsonReader2.mo610q() != 1 ? 2 : 1;
                            break;
                        case 4:
                            animatablePointValueM577u14 = AnimatableValueParser.m577u1(jsonReader2, lottieComposition);
                            break;
                        case 5:
                            animatablePointValueM577u15 = AnimatableValueParser.m577u1(jsonReader2, lottieComposition);
                            break;
                        case 6:
                            animatableFloatValueM561q1 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
                            break;
                        case 7:
                            i3 = C1563b.com$airbnb$lottie$model$content$ShapeStroke$LineCapType$s$values()[jsonReader2.mo610q() - 1];
                            break;
                        case 8:
                            i4 = C1563b.m753x4b958c1e()[jsonReader2.mo610q() - 1];
                            break;
                        case 9:
                            fMo609n = (float) jsonReader2.mo609n();
                            break;
                        case 10:
                            zMo608f7 = jsonReader2.mo608f();
                            break;
                        case 11:
                            jsonReader2.mo603a();
                            while (jsonReader2.mo607e()) {
                                jsonReader2.mo604b();
                                AnimatableFloatValue animatableFloatValueM561q12 = null;
                                String strMo612t9 = null;
                                while (jsonReader2.mo607e()) {
                                    int iMo615y7 = jsonReader2.mo615y(GradientStrokeParser.f2273c);
                                    if (iMo615y7 == 0) {
                                        strMo612t9 = jsonReader2.mo612t();
                                    } else if (iMo615y7 != 1) {
                                        jsonReader2.mo600A();
                                        jsonReader2.mo601C();
                                    } else {
                                        animatableFloatValueM561q12 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
                                    }
                                }
                                jsonReader2.mo606d();
                                if (strMo612t9.equals("o")) {
                                    animatableFloatValue = animatableFloatValueM561q12;
                                } else if (strMo612t9.equals("d") || strMo612t9.equals("g")) {
                                    lottieComposition.f2349n = true;
                                    arrayList2.add(animatableFloatValueM561q12);
                                }
                            }
                            jsonReader2.mo605c();
                            if (arrayList2.size() == 1) {
                                arrayList2.add(arrayList2.get(0));
                            }
                            break;
                        default:
                            jsonReader2.mo600A();
                            jsonReader2.mo601C();
                            break;
                    }
                }
                circleShape = new GradientStroke(strMo612t8, i2, animatableGradientColorValue2, animatableIntegerValueM569s13, animatablePointValueM577u14, animatablePointValueM577u15, animatableFloatValueM561q1, i3, i4, fMo609n, arrayList2, animatableFloatValue, zMo608f7);
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "mm":
                JsonReader2.a aVar6 = MergePathsParser.f2287a;
                MergePaths.a aVar7 = null;
                while (jsonReader2.mo607e()) {
                    int iMo615y8 = jsonReader2.mo615y(MergePathsParser.f2287a);
                    if (iMo615y8 == 0) {
                        strMo612t3 = jsonReader2.mo612t();
                    } else if (iMo615y8 == 1) {
                        int iMo610q6 = jsonReader2.mo610q();
                        MergePaths.a aVar8 = MergePaths.a.MERGE;
                        if (iMo610q6 != 1) {
                            if (iMo610q6 == 2) {
                                aVar7 = MergePaths.a.ADD;
                            } else if (iMo610q6 == 3) {
                                aVar7 = MergePaths.a.SUBTRACT;
                            } else if (iMo610q6 == 4) {
                                aVar7 = MergePaths.a.INTERSECT;
                            } else if (iMo610q6 == 5) {
                                aVar7 = MergePaths.a.EXCLUDE_INTERSECTIONS;
                            }
                        }
                        aVar7 = aVar8;
                    } else if (iMo615y8 != 2) {
                        jsonReader2.mo600A();
                        jsonReader2.mo601C();
                    } else {
                        zMo608f2 = jsonReader2.mo608f();
                    }
                }
                MergePaths mergePaths = new MergePaths(strMo612t3, aVar7, zMo608f2);
                lottieComposition.m669a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                circleShape = mergePaths;
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "rc":
                JsonReader2.a aVar9 = RectangleShapeParser.f2291a;
                String strMo612t10 = null;
                AnimatableValue<PointF, PointF> animatableValueM412b2 = null;
                AnimatablePointValue animatablePointValueM577u16 = null;
                AnimatableFloatValue animatableFloatValueM561q13 = null;
                boolean zMo608f8 = false;
                while (jsonReader2.mo607e()) {
                    int iMo615y9 = jsonReader2.mo615y(RectangleShapeParser.f2291a);
                    if (iMo615y9 == 0) {
                        strMo612t10 = jsonReader2.mo612t();
                    } else if (iMo615y9 == 1) {
                        animatableValueM412b2 = AnimatablePathValueParser.m412b(jsonReader2, lottieComposition);
                    } else if (iMo615y9 == 2) {
                        animatablePointValueM577u16 = AnimatableValueParser.m577u1(jsonReader2, lottieComposition);
                    } else if (iMo615y9 == 3) {
                        animatableFloatValueM561q13 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
                    } else if (iMo615y9 != 4) {
                        jsonReader2.mo601C();
                    } else {
                        zMo608f8 = jsonReader2.mo608f();
                    }
                }
                circleShape = new RectangleShape(strMo612t10, animatableValueM412b2, animatablePointValueM577u16, animatableFloatValueM561q13, zMo608f8);
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "rp":
                JsonReader2.a aVar10 = RepeaterParser.f2292a;
                String strMo612t11 = null;
                AnimatableFloatValue animatableFloatValueM565r1 = null;
                AnimatableFloatValue animatableFloatValueM565r12 = null;
                AnimatableTransform animatableTransformM414a = null;
                boolean zMo608f9 = false;
                while (jsonReader2.mo607e()) {
                    int iMo615y10 = jsonReader2.mo615y(RepeaterParser.f2292a);
                    if (iMo615y10 == 0) {
                        strMo612t11 = jsonReader2.mo612t();
                    } else if (iMo615y10 == 1) {
                        animatableFloatValueM565r1 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, false);
                    } else if (iMo615y10 == 2) {
                        animatableFloatValueM565r12 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, false);
                    } else if (iMo615y10 == 3) {
                        animatableTransformM414a = AnimatableTransformParser.m414a(jsonReader2, lottieComposition);
                    } else if (iMo615y10 != 4) {
                        jsonReader2.mo601C();
                    } else {
                        zMo608f9 = jsonReader2.mo608f();
                    }
                }
                circleShape = new Repeater(strMo612t11, animatableFloatValueM565r1, animatableFloatValueM565r12, animatableTransformM414a, zMo608f9);
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "sh":
                JsonReader2.a aVar11 = ShapePathParser.f2227a;
                boolean zMo608f10 = false;
                AnimatableShapeValue animatableShapeValue = null;
                while (jsonReader2.mo607e()) {
                    int iMo615y11 = jsonReader2.mo615y(ShapePathParser.f2227a);
                    if (iMo615y11 == 0) {
                        strMo612t4 = jsonReader2.mo612t();
                    } else if (iMo615y11 == 1) {
                        iMo610q = jsonReader2.mo610q();
                    } else if (iMo615y11 == 2) {
                        animatableShapeValue = new AnimatableShapeValue(KeyframesParser.m632a(jsonReader2, lottieComposition, Utils.m659c(), ShapeDataParser.f2211a));
                    } else if (iMo615y11 != 3) {
                        jsonReader2.mo601C();
                    } else {
                        zMo608f10 = jsonReader2.mo608f();
                    }
                }
                shapeGroup = new ShapePath2(strMo612t4, iMo610q, animatableShapeValue, zMo608f10);
                circleShape = shapeGroup;
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "sr":
                JsonReader2.a aVar12 = PolystarShapeParser.f2290a;
                String strMo612t12 = null;
                PolystarShape.a aVarM776f = null;
                AnimatableFloatValue animatableFloatValueM565r13 = null;
                AnimatableValue<PointF, PointF> animatableValueM412b3 = null;
                AnimatableFloatValue animatableFloatValueM565r14 = null;
                AnimatableFloatValue animatableFloatValueM561q14 = null;
                AnimatableFloatValue animatableFloatValueM561q15 = null;
                AnimatableFloatValue animatableFloatValueM565r15 = null;
                AnimatableFloatValue animatableFloatValueM565r16 = null;
                boolean zMo608f11 = false;
                while (jsonReader2.mo607e()) {
                    switch (jsonReader2.mo615y(PolystarShapeParser.f2290a)) {
                        case 0:
                            strMo612t12 = jsonReader2.mo612t();
                            break;
                        case 1:
                            aVarM776f = PolystarShape.a.m776f(jsonReader2.mo610q());
                            break;
                        case 2:
                            animatableFloatValueM565r13 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, false);
                            break;
                        case 3:
                            animatableValueM412b3 = AnimatablePathValueParser.m412b(jsonReader2, lottieComposition);
                            break;
                        case 4:
                            animatableFloatValueM565r14 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, false);
                            break;
                        case 5:
                            animatableFloatValueM561q15 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
                            break;
                        case 6:
                            animatableFloatValueM565r16 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, false);
                            break;
                        case 7:
                            animatableFloatValueM561q14 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
                            break;
                        case 8:
                            animatableFloatValueM565r15 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, false);
                            break;
                        case 9:
                            zMo608f11 = jsonReader2.mo608f();
                            break;
                        default:
                            jsonReader2.mo600A();
                            jsonReader2.mo601C();
                            break;
                    }
                }
                shapeGroup = new PolystarShape(strMo612t12, aVarM776f, animatableFloatValueM565r13, animatableValueM412b3, animatableFloatValueM565r14, animatableFloatValueM561q14, animatableFloatValueM561q15, animatableFloatValueM565r15, animatableFloatValueM565r16, zMo608f11);
                circleShape = shapeGroup;
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "st":
                JsonReader2.a aVar13 = ShapeStrokeParser.f2229a;
                ArrayList arrayList3 = new ArrayList();
                String strMo612t13 = null;
                AnimatableFloatValue animatableFloatValue2 = null;
                AnimatableColorValue animatableColorValueM557p12 = null;
                AnimatableIntegerValue animatableIntegerValueM569s14 = null;
                AnimatableFloatValue animatableFloatValueM561q16 = null;
                int i5 = 0;
                int i6 = 0;
                float fMo609n2 = 0.0f;
                boolean zMo608f12 = false;
                while (jsonReader2.mo607e()) {
                    switch (jsonReader2.mo615y(ShapeStrokeParser.f2229a)) {
                        case 0:
                            strMo612t13 = jsonReader2.mo612t();
                            break;
                        case 1:
                            animatableColorValueM557p12 = AnimatableValueParser.m557p1(jsonReader2, lottieComposition);
                            break;
                        case 2:
                            animatableFloatValueM561q16 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
                            break;
                        case 3:
                            animatableIntegerValueM569s14 = AnimatableValueParser.m569s1(jsonReader2, lottieComposition);
                            break;
                        case 4:
                            i5 = C1563b.com$airbnb$lottie$model$content$ShapeStroke$LineCapType$s$values()[jsonReader2.mo610q() - 1];
                            break;
                        case 5:
                            i6 = C1563b.m753x4b958c1e()[jsonReader2.mo610q() - 1];
                            break;
                        case 6:
                            fMo609n2 = (float) jsonReader2.mo609n();
                            break;
                        case 7:
                            zMo608f12 = jsonReader2.mo608f();
                            break;
                        case 8:
                            jsonReader2.mo603a();
                            while (jsonReader2.mo607e()) {
                                jsonReader2.mo604b();
                                AnimatableFloatValue animatableFloatValueM561q17 = null;
                                String strMo612t14 = null;
                                while (jsonReader2.mo607e()) {
                                    int iMo615y12 = jsonReader2.mo615y(ShapeStrokeParser.f2230b);
                                    if (iMo615y12 == 0) {
                                        strMo612t14 = jsonReader2.mo612t();
                                    } else if (iMo615y12 != 1) {
                                        jsonReader2.mo600A();
                                        jsonReader2.mo601C();
                                    } else {
                                        animatableFloatValueM561q17 = AnimatableValueParser.m561q1(jsonReader2, lottieComposition);
                                    }
                                }
                                jsonReader2.mo606d();
                                strMo612t14.hashCode();
                                int iHashCode = strMo612t14.hashCode();
                                if (iHashCode != 100) {
                                    if (iHashCode != 103) {
                                        b2 = (iHashCode == 111 && strMo612t14.equals("o")) ? (byte) 2 : (byte) -1;
                                    } else if (strMo612t14.equals("g")) {
                                        b2 = 1;
                                    }
                                } else if (strMo612t14.equals("d")) {
                                    b2 = 0;
                                }
                                if (b2 == 0 || b2 == 1) {
                                    lottieComposition.f2349n = true;
                                    arrayList3.add(animatableFloatValueM561q17);
                                } else if (b2 == 2) {
                                    animatableFloatValue2 = animatableFloatValueM561q17;
                                }
                            }
                            jsonReader2.mo605c();
                            if (arrayList3.size() == 1) {
                                arrayList3.add(arrayList3.get(0));
                            }
                            break;
                        default:
                            jsonReader2.mo601C();
                            break;
                    }
                }
                circleShape = new ShapeStroke(strMo612t13, animatableFloatValue2, arrayList3, animatableColorValueM557p12, animatableIntegerValueM569s14, animatableFloatValueM561q16, i5, i6, fMo609n2, zMo608f12);
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "tm":
                JsonReader2.a aVar14 = ShapeTrimPathParser.f2232a;
                String strMo612t15 = null;
                AnimatableFloatValue animatableFloatValueM565r17 = null;
                AnimatableFloatValue animatableFloatValueM565r18 = null;
                AnimatableFloatValue animatableFloatValueM565r19 = null;
                int i7 = 0;
                boolean zMo608f13 = false;
                while (jsonReader2.mo607e()) {
                    int iMo615y13 = jsonReader2.mo615y(ShapeTrimPathParser.f2232a);
                    if (iMo615y13 == 0) {
                        animatableFloatValueM565r17 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, false);
                    } else if (iMo615y13 == 1) {
                        animatableFloatValueM565r18 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, false);
                    } else if (iMo615y13 == 2) {
                        animatableFloatValueM565r19 = AnimatableValueParser.m565r1(jsonReader2, lottieComposition, false);
                    } else if (iMo615y13 == 3) {
                        strMo612t15 = jsonReader2.mo612t();
                    } else if (iMo615y13 == 4) {
                        int iMo610q7 = jsonReader2.mo610q();
                        if (iMo610q7 == 1) {
                            i7 = 1;
                        } else {
                            if (iMo610q7 != 2) {
                                throw new IllegalArgumentException(outline.m871q("Unknown trim path type ", iMo610q7));
                            }
                            i7 = 2;
                        }
                    } else if (iMo615y13 != 5) {
                        jsonReader2.mo601C();
                    } else {
                        zMo608f13 = jsonReader2.mo608f();
                    }
                }
                circleShape = new ShapeTrimPath(strMo612t15, i7, animatableFloatValueM565r17, animatableFloatValueM565r18, animatableFloatValueM565r19, zMo608f13);
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            case "tr":
                circleShape = AnimatableTransformParser.m414a(jsonReader2, lottieComposition);
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
            default:
                Logger2.m640b("Unknown shape type " + strMo612t2);
                while (jsonReader2.mo607e()) {
                }
                jsonReader2.mo606d();
                return circleShape;
        }
    }
}
