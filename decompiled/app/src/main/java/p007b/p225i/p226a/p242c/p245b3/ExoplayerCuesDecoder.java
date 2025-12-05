package p007b.p225i.p226a.p242c.p245b3;

import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.BundleableUtil;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.RegularImmutableList;

/* compiled from: ExoplayerCuesDecoder.java */
/* renamed from: b.i.a.c.b3.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class ExoplayerCuesDecoder implements SubtitleDecoder {

    /* renamed from: a */
    public final CueDecoder f5790a = new CueDecoder();

    /* renamed from: b */
    public final SubtitleInputBuffer f5791b = new SubtitleInputBuffer();

    /* renamed from: c */
    public final Deque<SubtitleOutputBuffer> f5792c = new ArrayDeque();

    /* renamed from: d */
    public int f5793d;

    /* renamed from: e */
    public boolean f5794e;

    /* compiled from: ExoplayerCuesDecoder.java */
    /* renamed from: b.i.a.c.b3.d$a */
    public class a extends SubtitleOutputBuffer {
        public a() {
        }

        @Override // p007b.p225i.p226a.p242c.p265v2.DecoderOutputBuffer
        /* renamed from: p */
        public void mo2611p() {
            ExoplayerCuesDecoder exoplayerCuesDecoder = ExoplayerCuesDecoder.this;
            AnimatableValueParser.m426D(exoplayerCuesDecoder.f5792c.size() < 2);
            AnimatableValueParser.m531j(!exoplayerCuesDecoder.f5792c.contains(this));
            m2618q();
            exoplayerCuesDecoder.f5792c.addFirst(this);
        }
    }

    /* compiled from: ExoplayerCuesDecoder.java */
    /* renamed from: b.i.a.c.b3.d$b */
    public static final class b implements Subtitle {

        /* renamed from: j */
        public final long f5796j;

        /* renamed from: k */
        public final ImmutableList2<Cue> f5797k;

        public b(long j, ImmutableList2<Cue> immutableList2) {
            this.f5796j = j;
            this.f5797k = immutableList2;
        }

        @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
        /* renamed from: f */
        public int mo2612f(long j) {
            return this.f5796j > j ? 0 : -1;
        }

        @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
        /* renamed from: g */
        public long mo2613g(int i) {
            AnimatableValueParser.m531j(i == 0);
            return this.f5796j;
        }

        @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
        /* renamed from: h */
        public List<Cue> mo2614h(long j) {
            if (j >= this.f5796j) {
                return this.f5797k;
            }
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
            return RegularImmutableList.f12012l;
        }

        @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
        /* renamed from: i */
        public int mo2615i() {
            return 1;
        }
    }

    public ExoplayerCuesDecoder() {
        for (int i = 0; i < 2; i++) {
            this.f5792c.addFirst(new a());
        }
        this.f5793d = 0;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.SubtitleDecoder
    /* renamed from: a */
    public void mo2607a(long j) {
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    @Nullable
    /* renamed from: b */
    public SubtitleOutputBuffer mo2608b() throws DecoderException {
        AnimatableValueParser.m426D(!this.f5794e);
        if (this.f5793d != 2 || this.f5792c.isEmpty()) {
            return null;
        }
        SubtitleOutputBuffer subtitleOutputBufferRemoveFirst = this.f5792c.removeFirst();
        if (this.f5791b.m3555n()) {
            subtitleOutputBufferRemoveFirst.m3551j(4);
        } else {
            SubtitleInputBuffer subtitleInputBuffer = this.f5791b;
            long j = subtitleInputBuffer.f19780n;
            CueDecoder cueDecoder = this.f5790a;
            ByteBuffer byteBuffer = subtitleInputBuffer.f19778l;
            Objects.requireNonNull(byteBuffer);
            byte[] bArrArray = byteBuffer.array();
            Objects.requireNonNull(cueDecoder);
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(bArrArray, 0, bArrArray.length);
            parcelObtain.setDataPosition(0);
            Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
            parcelObtain.recycle();
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("c");
            Objects.requireNonNull(parcelableArrayList);
            subtitleOutputBufferRemoveFirst.m2619r(this.f5791b.f19780n, new b(j, BundleableUtil.m3019a(Cue.f5755k, parcelableArrayList)), 0L);
        }
        this.f5791b.mo3856p();
        this.f5793d = 0;
        return subtitleOutputBufferRemoveFirst;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    @Nullable
    /* renamed from: c */
    public SubtitleInputBuffer mo2609c() throws DecoderException {
        AnimatableValueParser.m426D(!this.f5794e);
        if (this.f5793d != 0) {
            return null;
        }
        this.f5793d = 1;
        return this.f5791b;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    /* renamed from: d */
    public void mo2610d(SubtitleInputBuffer subtitleInputBuffer) throws DecoderException {
        SubtitleInputBuffer subtitleInputBuffer2 = subtitleInputBuffer;
        AnimatableValueParser.m426D(!this.f5794e);
        AnimatableValueParser.m426D(this.f5793d == 1);
        AnimatableValueParser.m531j(this.f5791b == subtitleInputBuffer2);
        this.f5793d = 2;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    public void flush() {
        AnimatableValueParser.m426D(!this.f5794e);
        this.f5791b.mo3856p();
        this.f5793d = 0;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.Decoder
    public void release() {
        this.f5794e = true;
    }
}
