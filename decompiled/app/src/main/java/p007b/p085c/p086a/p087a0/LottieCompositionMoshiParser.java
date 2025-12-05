package p007b.p085c.p086a.p087a0;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.LottieImageAsset;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p095y.Font;
import p007b.p085c.p086a.p095y.FontCharacter;
import p007b.p085c.p086a.p095y.Marker2;
import p007b.p085c.p086a.p095y.p097l.ShapeGroup;
import p007b.p085c.p086a.p095y.p098m.Layer2;

/* compiled from: LottieCompositionMoshiParser.java */
/* renamed from: b.c.a.a0.t, reason: use source file name */
/* loaded from: classes.dex */
public class LottieCompositionMoshiParser {

    /* renamed from: a */
    public static final JsonReader2.a f2283a = JsonReader2.a.m616a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b */
    public static JsonReader2.a f2284b = JsonReader2.a.m616a(ModelAuditLogEntry.CHANGE_KEY_ID, "layers", "w", "h", "p", "u");

    /* renamed from: c */
    public static final JsonReader2.a f2285c = JsonReader2.a.m616a("list");

    /* renamed from: d */
    public static final JsonReader2.a f2286d = JsonReader2.a.m616a("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0046. Please report as an issue. */
    /* renamed from: a */
    public static LottieComposition m635a(JsonReader2 jsonReader2) throws IOException, NumberFormatException {
        ArrayList arrayList;
        SparseArrayCompat<FontCharacter> sparseArrayCompat;
        ArrayList arrayList2;
        float f;
        float f2;
        float f3;
        float fM659c = Utils.m659c();
        LongSparseArray<Layer2> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList3 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        SparseArrayCompat<FontCharacter> sparseArrayCompat2 = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader2.mo604b();
        float fMo609n = 0.0f;
        int iMo610q = 0;
        int iMo610q2 = 0;
        float fMo609n2 = 0.0f;
        float fMo609n3 = 0.0f;
        while (jsonReader2.mo607e()) {
            float f4 = fMo609n;
            switch (jsonReader2.mo615y(f2283a)) {
                case 0:
                    iMo610q = jsonReader2.mo610q();
                    fMo609n = f4;
                    break;
                case 1:
                    iMo610q2 = jsonReader2.mo610q();
                    fMo609n = f4;
                    break;
                case 2:
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat2;
                    fMo609n2 = (float) jsonReader2.mo609n();
                    fMo609n = f4;
                    arrayList4 = arrayList;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 3:
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat2;
                    fMo609n3 = ((float) jsonReader2.mo609n()) - 0.01f;
                    fMo609n = f4;
                    arrayList4 = arrayList;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 4:
                    arrayList = arrayList4;
                    sparseArrayCompat = sparseArrayCompat2;
                    fMo609n = (float) jsonReader2.mo609n();
                    arrayList4 = arrayList;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 5:
                    arrayList2 = arrayList4;
                    sparseArrayCompat = sparseArrayCompat2;
                    f = fMo609n2;
                    f2 = fMo609n3;
                    String[] strArrSplit = jsonReader2.mo612t().split("\\.");
                    int i = Integer.parseInt(strArrSplit[0]);
                    boolean z2 = true;
                    int i2 = Integer.parseInt(strArrSplit[1]);
                    int i3 = Integer.parseInt(strArrSplit[2]);
                    if (i < 4 || (i <= 4 && (i2 < 4 || (i2 <= 4 && i3 < 0)))) {
                        z2 = false;
                    }
                    if (!z2) {
                        lottieComposition.m669a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    fMo609n = f4;
                    fMo609n2 = f;
                    arrayList4 = arrayList2;
                    fMo609n3 = f2;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 6:
                    arrayList2 = arrayList4;
                    sparseArrayCompat = sparseArrayCompat2;
                    f = fMo609n2;
                    f2 = fMo609n3;
                    jsonReader2.mo603a();
                    int i4 = 0;
                    while (jsonReader2.mo607e()) {
                        Layer2 layer2M634a = LayerParser.m634a(jsonReader2, lottieComposition);
                        if (layer2M634a.f2872e == Layer2.a.IMAGE) {
                            i4++;
                        }
                        arrayList3.add(layer2M634a);
                        longSparseArray.put(layer2M634a.f2871d, layer2M634a);
                        if (i4 > 4) {
                            Logger2.m640b("You have " + i4 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    jsonReader2.mo605c();
                    fMo609n = f4;
                    fMo609n2 = f;
                    arrayList4 = arrayList2;
                    fMo609n3 = f2;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 7:
                    arrayList2 = arrayList4;
                    sparseArrayCompat = sparseArrayCompat2;
                    f = fMo609n2;
                    f2 = fMo609n3;
                    jsonReader2.mo603a();
                    while (jsonReader2.mo607e()) {
                        ArrayList arrayList5 = new ArrayList();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        jsonReader2.mo604b();
                        String strMo612t = null;
                        String strMo612t2 = null;
                        String strMo612t3 = null;
                        int iMo610q3 = 0;
                        int iMo610q4 = 0;
                        while (jsonReader2.mo607e()) {
                            int iMo615y = jsonReader2.mo615y(f2284b);
                            if (iMo615y == 0) {
                                strMo612t = jsonReader2.mo612t();
                            } else if (iMo615y == 1) {
                                jsonReader2.mo603a();
                                while (jsonReader2.mo607e()) {
                                    Layer2 layer2M634a2 = LayerParser.m634a(jsonReader2, lottieComposition);
                                    longSparseArray2.put(layer2M634a2.f2871d, layer2M634a2);
                                    arrayList5.add(layer2M634a2);
                                }
                                jsonReader2.mo605c();
                            } else if (iMo615y == 2) {
                                iMo610q3 = jsonReader2.mo610q();
                            } else if (iMo615y == 3) {
                                iMo610q4 = jsonReader2.mo610q();
                            } else if (iMo615y == 4) {
                                strMo612t2 = jsonReader2.mo612t();
                            } else if (iMo615y != 5) {
                                jsonReader2.mo600A();
                                jsonReader2.mo601C();
                            } else {
                                strMo612t3 = jsonReader2.mo612t();
                            }
                        }
                        jsonReader2.mo606d();
                        if (strMo612t2 != null) {
                            map2.put(strMo612t, new LottieImageAsset(iMo610q3, iMo610q4, strMo612t, strMo612t2, strMo612t3));
                        } else {
                            map.put(strMo612t, arrayList5);
                        }
                    }
                    jsonReader2.mo605c();
                    fMo609n = f4;
                    fMo609n2 = f;
                    arrayList4 = arrayList2;
                    fMo609n3 = f2;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 8:
                    f = fMo609n2;
                    f2 = fMo609n3;
                    jsonReader2.mo604b();
                    while (jsonReader2.mo607e()) {
                        if (jsonReader2.mo615y(f2285c) != 0) {
                            jsonReader2.mo600A();
                            jsonReader2.mo601C();
                        } else {
                            jsonReader2.mo603a();
                            while (jsonReader2.mo607e()) {
                                JsonReader2.a aVar = FontParser.f2267a;
                                jsonReader2.mo604b();
                                String strMo612t4 = null;
                                String strMo612t5 = null;
                                String strMo612t6 = null;
                                float fMo609n4 = 0.0f;
                                while (jsonReader2.mo607e()) {
                                    ArrayList arrayList6 = arrayList4;
                                    int iMo615y2 = jsonReader2.mo615y(FontParser.f2267a);
                                    if (iMo615y2 != 0) {
                                        SparseArrayCompat<FontCharacter> sparseArrayCompat3 = sparseArrayCompat2;
                                        if (iMo615y2 == 1) {
                                            strMo612t5 = jsonReader2.mo612t();
                                        } else if (iMo615y2 == 2) {
                                            strMo612t6 = jsonReader2.mo612t();
                                        } else if (iMo615y2 != 3) {
                                            jsonReader2.mo600A();
                                            jsonReader2.mo601C();
                                        } else {
                                            fMo609n4 = (float) jsonReader2.mo609n();
                                        }
                                        arrayList4 = arrayList6;
                                        sparseArrayCompat2 = sparseArrayCompat3;
                                    } else {
                                        strMo612t4 = jsonReader2.mo612t();
                                        arrayList4 = arrayList6;
                                    }
                                }
                                jsonReader2.mo606d();
                                map3.put(strMo612t5, new Font(strMo612t4, strMo612t5, strMo612t6, fMo609n4));
                                arrayList4 = arrayList4;
                            }
                            jsonReader2.mo605c();
                        }
                    }
                    arrayList2 = arrayList4;
                    sparseArrayCompat = sparseArrayCompat2;
                    jsonReader2.mo606d();
                    fMo609n = f4;
                    fMo609n2 = f;
                    arrayList4 = arrayList2;
                    fMo609n3 = f2;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 9:
                    f = fMo609n2;
                    f2 = fMo609n3;
                    jsonReader2.mo603a();
                    while (jsonReader2.mo607e()) {
                        JsonReader2.a aVar2 = FontCharacterParser.f2265a;
                        ArrayList arrayList7 = new ArrayList();
                        jsonReader2.mo604b();
                        double dMo609n = 0.0d;
                        double dMo609n2 = 0.0d;
                        String strMo612t7 = null;
                        String strMo612t8 = null;
                        char cCharAt = 0;
                        while (jsonReader2.mo607e()) {
                            int iMo615y3 = jsonReader2.mo615y(FontCharacterParser.f2265a);
                            if (iMo615y3 == 0) {
                                cCharAt = jsonReader2.mo612t().charAt(0);
                            } else if (iMo615y3 == 1) {
                                dMo609n = jsonReader2.mo609n();
                            } else if (iMo615y3 == 2) {
                                dMo609n2 = jsonReader2.mo609n();
                            } else if (iMo615y3 == 3) {
                                strMo612t7 = jsonReader2.mo612t();
                            } else if (iMo615y3 == 4) {
                                strMo612t8 = jsonReader2.mo612t();
                            } else if (iMo615y3 != 5) {
                                jsonReader2.mo600A();
                                jsonReader2.mo601C();
                            } else {
                                jsonReader2.mo604b();
                                while (jsonReader2.mo607e()) {
                                    if (jsonReader2.mo615y(FontCharacterParser.f2266b) != 0) {
                                        jsonReader2.mo600A();
                                        jsonReader2.mo601C();
                                    } else {
                                        jsonReader2.mo603a();
                                        while (jsonReader2.mo607e()) {
                                            arrayList7.add((ShapeGroup) ContentModelParser.m599a(jsonReader2, lottieComposition));
                                        }
                                        jsonReader2.mo605c();
                                    }
                                }
                                jsonReader2.mo606d();
                            }
                        }
                        jsonReader2.mo606d();
                        FontCharacter fontCharacter = new FontCharacter(arrayList7, cCharAt, dMo609n, dMo609n2, strMo612t7, strMo612t8);
                        sparseArrayCompat2.put(fontCharacter.hashCode(), fontCharacter);
                    }
                    jsonReader2.mo605c();
                    arrayList2 = arrayList4;
                    sparseArrayCompat = sparseArrayCompat2;
                    fMo609n = f4;
                    fMo609n2 = f;
                    arrayList4 = arrayList2;
                    fMo609n3 = f2;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case 10:
                    jsonReader2.mo603a();
                    while (jsonReader2.mo607e()) {
                        jsonReader2.mo604b();
                        String strMo612t9 = null;
                        float fMo609n5 = 0.0f;
                        float fMo609n6 = 0.0f;
                        while (jsonReader2.mo607e()) {
                            int iMo615y4 = jsonReader2.mo615y(f2286d);
                            if (iMo615y4 != 0) {
                                float f5 = fMo609n3;
                                if (iMo615y4 == 1) {
                                    f3 = fMo609n2;
                                    fMo609n5 = (float) jsonReader2.mo609n();
                                } else if (iMo615y4 != 2) {
                                    jsonReader2.mo600A();
                                    jsonReader2.mo601C();
                                    fMo609n3 = f5;
                                } else {
                                    f3 = fMo609n2;
                                    fMo609n6 = (float) jsonReader2.mo609n();
                                }
                                fMo609n3 = f5;
                                fMo609n2 = f3;
                            } else {
                                strMo612t9 = jsonReader2.mo612t();
                            }
                        }
                        jsonReader2.mo606d();
                        arrayList4.add(new Marker2(strMo612t9, fMo609n5, fMo609n6));
                        fMo609n2 = fMo609n2;
                        fMo609n3 = fMo609n3;
                    }
                    f = fMo609n2;
                    f2 = fMo609n3;
                    jsonReader2.mo605c();
                    arrayList2 = arrayList4;
                    sparseArrayCompat = sparseArrayCompat2;
                    fMo609n = f4;
                    fMo609n2 = f;
                    arrayList4 = arrayList2;
                    fMo609n3 = f2;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                default:
                    arrayList2 = arrayList4;
                    sparseArrayCompat = sparseArrayCompat2;
                    f = fMo609n2;
                    f2 = fMo609n3;
                    jsonReader2.mo600A();
                    jsonReader2.mo601C();
                    fMo609n = f4;
                    fMo609n2 = f;
                    arrayList4 = arrayList2;
                    fMo609n3 = f2;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
            }
        }
        lottieComposition.f2345j = new Rect(0, 0, (int) (iMo610q * fM659c), (int) (iMo610q2 * fM659c));
        lottieComposition.f2346k = fMo609n2;
        lottieComposition.f2347l = fMo609n3;
        lottieComposition.f2348m = fMo609n;
        lottieComposition.f2344i = arrayList3;
        lottieComposition.f2343h = longSparseArray;
        lottieComposition.f2338c = map;
        lottieComposition.f2339d = map2;
        lottieComposition.f2342g = sparseArrayCompat2;
        lottieComposition.f2340e = map3;
        lottieComposition.f2341f = arrayList4;
        return lottieComposition;
    }
}
