package b.i.a.c.b3.n;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.b3.g;
import b.i.a.c.b3.h;
import b.i.a.c.b3.j;
import b.i.a.c.b3.k;
import b.i.a.c.f3.e0;
import b.i.a.c.v2.f;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.PriorityQueue;

/* compiled from: CeaDecoder.java */
/* loaded from: classes3.dex */
public abstract class e implements h {
    public final ArrayDeque<b> a = new ArrayDeque<>();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<k> f860b;
    public final PriorityQueue<b> c;

    @Nullable
    public b d;
    public long e;
    public long f;

    /* compiled from: CeaDecoder.java */
    public static final class b extends j implements Comparable<b> {

        /* renamed from: s, reason: collision with root package name */
        public long f861s;

        public b() {
        }

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            b bVar2 = bVar;
            if (n() == bVar2.n()) {
                long j = this.n - bVar2.n;
                if (j == 0) {
                    j = this.f861s - bVar2.f861s;
                    if (j == 0) {
                        return 0;
                    }
                }
                if (j > 0) {
                    return 1;
                }
            } else if (n()) {
                return 1;
            }
            return -1;
        }

        public b(a aVar) {
        }
    }

    /* compiled from: CeaDecoder.java */
    public static final class c extends k {
        public f.a<c> n;

        public c(f.a<c> aVar) {
            this.n = aVar;
        }

        @Override // b.i.a.c.v2.f
        public final void p() {
            e eVar = ((b.i.a.c.b3.n.b) this.n).a;
            Objects.requireNonNull(eVar);
            q();
            eVar.f860b.add(this);
        }
    }

    public e() {
        for (int i = 0; i < 10; i++) {
            this.a.add(new b(null));
        }
        this.f860b = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.f860b.add(new c(new b.i.a.c.b3.n.b(this)));
        }
        this.c = new PriorityQueue<>();
    }

    @Override // b.i.a.c.b3.h
    public void a(long j) {
        this.e = j;
    }

    @Override // b.i.a.c.v2.d
    @Nullable
    public /* bridge */ /* synthetic */ k b() throws DecoderException {
        return g();
    }

    @Override // b.i.a.c.v2.d
    @Nullable
    public j c() throws DecoderException {
        b.c.a.a0.d.D(this.d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.a.pollFirst();
        this.d = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // b.i.a.c.v2.d
    public void d(j jVar) throws DecoderException {
        j jVar2 = jVar;
        b.c.a.a0.d.j(jVar2 == this.d);
        b bVar = (b) jVar2;
        if (bVar.m()) {
            i(bVar);
        } else {
            long j = this.f;
            this.f = 1 + j;
            bVar.f861s = j;
            this.c.add(bVar);
        }
        this.d = null;
    }

    public abstract g e();

    public abstract void f(j jVar);

    @Override // b.i.a.c.v2.d
    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            b bVarPoll = this.c.poll();
            int i = e0.a;
            i(bVarPoll);
        }
        b bVar = this.d;
        if (bVar != null) {
            i(bVar);
            this.d = null;
        }
    }

    @Nullable
    public k g() throws SubtitleDecoderException {
        if (this.f860b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty()) {
            b bVarPeek = this.c.peek();
            int i = e0.a;
            if (bVarPeek.n > this.e) {
                break;
            }
            b bVarPoll = this.c.poll();
            if (bVarPoll.n()) {
                k kVarPollFirst = this.f860b.pollFirst();
                kVarPollFirst.j(4);
                i(bVarPoll);
                return kVarPollFirst;
            }
            f(bVarPoll);
            if (h()) {
                g gVarE = e();
                k kVarPollFirst2 = this.f860b.pollFirst();
                kVarPollFirst2.r(bVarPoll.n, gVarE, RecyclerView.FOREVER_NS);
                i(bVarPoll);
                return kVarPollFirst2;
            }
            i(bVarPoll);
        }
        return null;
    }

    public abstract boolean h();

    public final void i(b bVar) {
        bVar.p();
        this.a.add(bVar);
    }

    @Override // b.i.a.c.v2.d
    public void release() {
    }
}
