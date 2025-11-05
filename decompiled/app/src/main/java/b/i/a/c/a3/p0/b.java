package b.i.a.c.a3.p0;

import android.os.Bundle;
import b.i.a.c.a3.p0.c;
import b.i.a.c.w0;
import java.util.ArrayList;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements w0.a {
    public static final /* synthetic */ b a = new b();

    @Override // b.i.a.c.w0.a
    public final w0 a(Bundle bundle) {
        c.a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(c.b(1));
        if (parcelableArrayList == null) {
            aVarArr = new c.a[0];
        } else {
            c.a[] aVarArr2 = new c.a[parcelableArrayList.size()];
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                int i2 = c.a.j;
                aVarArr2[i] = (c.a) a.a.a((Bundle) parcelableArrayList.get(i));
            }
            aVarArr = aVarArr2;
        }
        return new c(null, aVarArr, bundle.getLong(c.b(2), 0L), bundle.getLong(c.b(3), -9223372036854775807L), bundle.getInt(c.b(4)));
    }
}
