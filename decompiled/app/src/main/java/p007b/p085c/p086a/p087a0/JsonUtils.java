package p007b.p085c.p086a.p087a0;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.c.a.a0.p, reason: use source file name */
/* JADX INFO: compiled from: JsonUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class JsonUtils {

    /* JADX INFO: renamed from: a */
    public static final JsonReader2.a f2275a = JsonReader2.a.m616a("x", "y");

    @ColorInt
    /* JADX INFO: renamed from: a */
    public static int m627a(JsonReader2 jsonReader2) throws IOException {
        jsonReader2.mo603a();
        int iMo609n = (int) (jsonReader2.mo609n() * 255.0d);
        int iMo609n2 = (int) (jsonReader2.mo609n() * 255.0d);
        int iMo609n3 = (int) (jsonReader2.mo609n() * 255.0d);
        while (jsonReader2.mo607e()) {
            jsonReader2.mo601C();
        }
        jsonReader2.mo605c();
        return Color.argb(255, iMo609n, iMo609n2, iMo609n3);
    }

    /* JADX INFO: renamed from: b */
    public static PointF m628b(JsonReader2 jsonReader2, float f) throws IOException {
        int iOrdinal = jsonReader2.mo613u().ordinal();
        if (iOrdinal == 0) {
            jsonReader2.mo603a();
            float fMo609n = (float) jsonReader2.mo609n();
            float fMo609n2 = (float) jsonReader2.mo609n();
            while (jsonReader2.mo613u() != JsonReader2.b.END_ARRAY) {
                jsonReader2.mo601C();
            }
            jsonReader2.mo605c();
            return new PointF(fMo609n * f, fMo609n2 * f);
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 6) {
                StringBuilder sbM833U = outline.m833U("Unknown point starts with ");
                sbM833U.append(jsonReader2.mo613u());
                throw new IllegalArgumentException(sbM833U.toString());
            }
            float fMo609n3 = (float) jsonReader2.mo609n();
            float fMo609n4 = (float) jsonReader2.mo609n();
            while (jsonReader2.mo607e()) {
                jsonReader2.mo601C();
            }
            return new PointF(fMo609n3 * f, fMo609n4 * f);
        }
        jsonReader2.mo604b();
        float fM630d = 0.0f;
        float fM630d2 = 0.0f;
        while (jsonReader2.mo607e()) {
            int iMo615y = jsonReader2.mo615y(f2275a);
            if (iMo615y == 0) {
                fM630d = m630d(jsonReader2);
            } else if (iMo615y != 1) {
                jsonReader2.mo600A();
                jsonReader2.mo601C();
            } else {
                fM630d2 = m630d(jsonReader2);
            }
        }
        jsonReader2.mo606d();
        return new PointF(fM630d * f, fM630d2 * f);
    }

    /* JADX INFO: renamed from: c */
    public static List<PointF> m629c(JsonReader2 jsonReader2, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader2.mo603a();
        while (jsonReader2.mo613u() == JsonReader2.b.BEGIN_ARRAY) {
            jsonReader2.mo603a();
            arrayList.add(m628b(jsonReader2, f));
            jsonReader2.mo605c();
        }
        jsonReader2.mo605c();
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    public static float m630d(JsonReader2 jsonReader2) throws IOException {
        JsonReader2.b bVarMo613u = jsonReader2.mo613u();
        int iOrdinal = bVarMo613u.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 6) {
                return (float) jsonReader2.mo609n();
            }
            throw new IllegalArgumentException("Unknown value for token of type " + bVarMo613u);
        }
        jsonReader2.mo603a();
        float fMo609n = (float) jsonReader2.mo609n();
        while (jsonReader2.mo607e()) {
            jsonReader2.mo601C();
        }
        jsonReader2.mo605c();
        return fMo609n;
    }
}
