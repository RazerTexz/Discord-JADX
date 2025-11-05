package b.i.a.c.a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: BundledExtractorsAdapter.java */
/* loaded from: classes3.dex */
public final class m implements d0 {
    public final b.i.a.c.x2.l a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public b.i.a.c.x2.h f828b;

    @Nullable
    public b.i.a.c.x2.i c;

    public m(b.i.a.c.x2.l lVar) {
        this.a = lVar;
    }

    public long a() {
        b.i.a.c.x2.i iVar = this.c;
        if (iVar != null) {
            return iVar.getPosition();
        }
        return -1L;
    }

    public void b(b.i.a.c.e3.h hVar, Uri uri, Map<String, List<String>> map, long j, long j2, b.i.a.c.x2.j jVar) throws IOException {
        b.i.a.c.x2.e eVar = new b.i.a.c.x2.e(hVar, j, j2);
        this.c = eVar;
        if (this.f828b != null) {
            return;
        }
        b.i.a.c.x2.h[] hVarArrB = this.a.b(uri, map);
        boolean z2 = true;
        if (hVarArrB.length == 1) {
            this.f828b = hVarArrB[0];
        } else {
            int length = hVarArrB.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                b.i.a.c.x2.h hVar2 = hVarArrB[i];
                try {
                } catch (EOFException unused) {
                    if (this.f828b != null || eVar.d == j) {
                    }
                } catch (Throwable th) {
                    if (this.f828b == null && eVar.d != j) {
                        z2 = false;
                    }
                    b.c.a.a0.d.D(z2);
                    eVar.f = 0;
                    throw th;
                }
                if (hVar2.b(eVar)) {
                    this.f828b = hVar2;
                    b.c.a.a0.d.D(true);
                    eVar.f = 0;
                    break;
                } else {
                    boolean z3 = this.f828b != null || eVar.d == j;
                    b.c.a.a0.d.D(z3);
                    eVar.f = 0;
                    i++;
                }
            }
            if (this.f828b == null) {
                int i2 = b.i.a.c.f3.e0.a;
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < hVarArrB.length; i3++) {
                    sb.append(hVarArrB[i3].getClass().getSimpleName());
                    if (i3 < hVarArrB.length - 1) {
                        sb.append(", ");
                    }
                }
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder(b.d.b.a.a.b(string, 58));
                sb2.append("None of the available extractors (");
                sb2.append(string);
                sb2.append(") could read the stream.");
                String string2 = sb2.toString();
                Objects.requireNonNull(uri);
                throw new UnrecognizedInputFormatException(string2, uri);
            }
        }
        this.f828b.f(jVar);
    }
}
