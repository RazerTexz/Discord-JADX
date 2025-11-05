package b.i.a.b.j.t.i;

import android.database.Cursor;
import android.util.Base64;
import b.i.a.b.j.b;
import b.i.a.b.j.i;
import b.i.a.b.j.t.i.t;
import java.util.ArrayList;

/* compiled from: SQLiteEventStore.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class p implements t.b {
    public static final p a = new p();

    @Override // b.i.a.b.j.t.i.t.b
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        b.i.a.b.b bVar = t.j;
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            i.a aVarA = b.i.a.b.j.i.a();
            aVarA.b(cursor.getString(1));
            aVarA.c(b.i.a.b.j.w.a.b(cursor.getInt(2)));
            String string = cursor.getString(3);
            b.C0087b c0087b = (b.C0087b) aVarA;
            c0087b.f764b = string == null ? null : Base64.decode(string, 0);
            arrayList.add(c0087b.a());
        }
        return arrayList;
    }
}
