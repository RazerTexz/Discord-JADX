package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;

/* compiled from: TsPayloadReader.java */
/* loaded from: classes3.dex */
public interface i0 {

    /* compiled from: TsPayloadReader.java */
    public static final class a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f1257b;

        public a(String str, int i, byte[] bArr) {
            this.a = str;
            this.f1257b = bArr;
        }
    }

    /* compiled from: TsPayloadReader.java */
    public static final class b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f1258b;
        public final List<a> c;
        public final byte[] d;

        public b(int i, @Nullable String str, @Nullable List<a> list, byte[] bArr) {
            this.a = i;
            this.f1258b = str;
            this.c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.d = bArr;
        }
    }

    /* compiled from: TsPayloadReader.java */
    public interface c {
        @Nullable
        i0 a(int i, b bVar);
    }

    /* compiled from: TsPayloadReader.java */
    public static final class d {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1259b;
        public final int c;
        public int d;
        public String e;

        public d(int i, int i2, int i3) {
            String string;
            if (i != Integer.MIN_VALUE) {
                StringBuilder sb = new StringBuilder(12);
                sb.append(i);
                sb.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
                string = sb.toString();
            } else {
                string = "";
            }
            this.a = string;
            this.f1259b = i2;
            this.c = i3;
            this.d = Integer.MIN_VALUE;
            this.e = "";
        }

        public void a() {
            int i = this.d;
            int i2 = i == Integer.MIN_VALUE ? this.f1259b : i + this.c;
            this.d = i2;
            String str = this.a;
            this.e = b.d.b.a.a.g(b.d.b.a.a.b(str, 11), str, i2);
        }

        public String b() {
            if (this.d != Integer.MIN_VALUE) {
                return this.e;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public int c() {
            int i = this.d;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    void a(b.i.a.c.f3.d0 d0Var, b.i.a.c.x2.j jVar, d dVar);

    void b(b.i.a.c.f3.x xVar, int i) throws ParserException;

    void c();
}
