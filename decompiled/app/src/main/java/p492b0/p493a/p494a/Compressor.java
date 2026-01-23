package p492b0.p493a.p494a;

import android.graphics.Bitmap;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p492b0.p493a.p494a.p495e.Compression;
import p492b0.p493a.p494a.p495e.DefaultConstraint;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b0.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: Compressor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Compressor extends Lambda implements Function1<Compression, Unit> {

    /* JADX INFO: renamed from: j */
    public static final Compressor f14501j = new Compressor();

    public Compressor() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Compression compression) {
        Compression compression2 = compression;
        Intrinsics3.checkParameterIsNotNull(compression2, "$receiver");
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        Intrinsics3.checkParameterIsNotNull(compression2, "$this$default");
        Intrinsics3.checkParameterIsNotNull(compressFormat, "format");
        DefaultConstraint defaultConstraint = new DefaultConstraint(612, 816, compressFormat, 80);
        Objects.requireNonNull(compression2);
        Intrinsics3.checkParameterIsNotNull(defaultConstraint, "constraint");
        compression2.f14505a.add(defaultConstraint);
        return Unit.f27425a;
    }
}
