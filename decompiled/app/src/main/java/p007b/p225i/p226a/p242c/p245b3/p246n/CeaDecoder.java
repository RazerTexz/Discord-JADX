package p007b.p225i.p226a.p242c.p245b3.p246n;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.PriorityQueue;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p245b3.SubtitleDecoder;
import p007b.p225i.p226a.p242c.p245b3.SubtitleInputBuffer;
import p007b.p225i.p226a.p242c.p245b3.SubtitleOutputBuffer;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p265v2.DecoderOutputBuffer;

/* compiled from: CeaDecoder.java */
/* renamed from: b.i.a.c.b3.n.e, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class CeaDecoder implements SubtitleDecoder {

    /* renamed from: a */
    public final ArrayDeque<b> f5906a = new ArrayDeque<>();

    /* renamed from: b */
    public final ArrayDeque<SubtitleOutputBuffer> f5907b;

    /* renamed from: c */
    public final PriorityQueue<b> f5908c;

    /* renamed from: d */
    @Nullable
    public b f5909d;

    /* renamed from: e */
    public long f5910e;

    /* renamed from: f */
    public long f5911f;

    /* compiled from: CeaDecoder.java */
    /* renamed from: b.i.a.c.b3.n.e$b */
    public static final class b extends SubtitleInputBuffer implements Comparable<b> {

        /* renamed from: s */
        public long f5912s;

        public b() {
        }

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            b bVar2 = bVar;
            if (m3555n() == bVar2.m3555n()) {
                long j = this.f19780n - bVar2.f19780n;
                if (j == 0) {
                    j = this.f5912s - bVar2.f5912s;
                    if (j == 0) {
                        return 0;
                    }
                }
                if (j > 0) {
                    return 1;
                }
            } else if (m3555n()) {
                return 1;
            }
            return -1;
        }

        public b(a aVar) {
        }
    }

    /* compiled from: CeaDecoder.java */
    /* renamed from: b.i.a.c.b3.n.e$c */
    public static final class c extends SubtitleOutputBuffer {

        /* renamed from: n */
        public DecoderOutputBuffer.a<c> f5913n;

        public c(DecoderOutputBuffer.a<c> aVar) {
            this.f5913n = aVar;
        }

        @Override // p007b.p225i.p226a.p242c.p265v2.DecoderOutputBuffer
        /* renamed from: p */
        public final void mo2611p() {
            CeaDecoder ceaDecoder = ((C2591b) this.f5913n).f5819a;
            Objects.requireNonNull(ceaDecoder);
            m2618q();
            ceaDecoder.f5907b.add(this);
        }
    }

    public CeaDecoder() {
        for (int i = 0; i < 10; i++) {
            this.f5906a.add(new b(null));
        }
        this.f5907b = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.f5907b.add(new c(new C2591b(this)));
        }
        this.f5908c = new PriorityQueue<>();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.SubtitleDecoder
    /* renamed from: a */
    public void mo2607a(long j) {
        this.f5910e = j;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    @Nullable
    /* renamed from: b */
    public /* bridge */ /* synthetic */ SubtitleOutputBuffer mo2608b() throws DecoderException {
        return mo2636g();
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    @Nullable
    /* renamed from: c */
    public SubtitleInputBuffer mo2609c() throws DecoderException {
        AnimatableValueParser.m426D(this.f5909d == null);
        if (this.f5906a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.f5906a.pollFirst();
        this.f5909d = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    /* renamed from: d */
    public void mo2610d(SubtitleInputBuffer subtitleInputBuffer) throws DecoderException {
        SubtitleInputBuffer subtitleInputBuffer2 = subtitleInputBuffer;
        AnimatableValueParser.m531j(subtitleInputBuffer2 == this.f5909d);
        b bVar = (b) subtitleInputBuffer2;
        if (bVar.m3554m()) {
            m2659i(bVar);
        } else {
            long j = this.f5911f;
            this.f5911f = 1 + j;
            bVar.f5912s = j;
            this.f5908c.add(bVar);
        }
        this.f5909d = null;
    }

    /* renamed from: e */
    public abstract Subtitle mo2634e();

    /* renamed from: f */
    public abstract void mo2635f(SubtitleInputBuffer subtitleInputBuffer);

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    public void flush() {
        this.f5911f = 0L;
        this.f5910e = 0L;
        while (!this.f5908c.isEmpty()) {
            b bVarPoll = this.f5908c.poll();
            int i = Util2.f6708a;
            m2659i(bVarPoll);
        }
        b bVar = this.f5909d;
        if (bVar != null) {
            m2659i(bVar);
            this.f5909d = null;
        }
    }

    @Nullable
    /* renamed from: g */
    public SubtitleOutputBuffer mo2636g() throws SubtitleDecoderException {
        if (this.f5907b.isEmpty()) {
            return null;
        }
        while (!this.f5908c.isEmpty()) {
            b bVarPeek = this.f5908c.peek();
            int i = Util2.f6708a;
            if (bVarPeek.f19780n > this.f5910e) {
                break;
            }
            b bVarPoll = this.f5908c.poll();
            if (bVarPoll.m3555n()) {
                SubtitleOutputBuffer subtitleOutputBufferPollFirst = this.f5907b.pollFirst();
                subtitleOutputBufferPollFirst.m3551j(4);
                m2659i(bVarPoll);
                return subtitleOutputBufferPollFirst;
            }
            mo2635f(bVarPoll);
            if (mo2637h()) {
                Subtitle subtitleMo2634e = mo2634e();
                SubtitleOutputBuffer subtitleOutputBufferPollFirst2 = this.f5907b.pollFirst();
                subtitleOutputBufferPollFirst2.m2619r(bVarPoll.f19780n, subtitleMo2634e, RecyclerView.FOREVER_NS);
                m2659i(bVarPoll);
                return subtitleOutputBufferPollFirst2;
            }
            m2659i(bVarPoll);
        }
        return null;
    }

    /* renamed from: h */
    public abstract boolean mo2637h();

    /* renamed from: i */
    public final void m2659i(b bVar) {
        bVar.mo3856p();
        this.f5906a.add(bVar);
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    public void release() {
    }
}
