package p007b.p085c.p086a.p087a0;

import android.graphics.PointF;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;

/* JADX INFO: renamed from: b.c.a.a0.v, reason: use source file name */
/* JADX INFO: compiled from: PathParser.java */
/* JADX INFO: loaded from: classes.dex */
public class PathParser2 implements ValueParser<PointF> {

    /* JADX INFO: renamed from: a */
    public static final PathParser2 f2288a = new PathParser2();

    @Override // p007b.p085c.p086a.p087a0.ValueParser
    /* JADX INFO: renamed from: a */
    public PointF mo413a(JsonReader2 jsonReader2, float f) throws IOException {
        return JsonUtils.m628b(jsonReader2, f);
    }
}
