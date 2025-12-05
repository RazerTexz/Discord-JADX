package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.BaseRenderer;
import p007b.p225i.p226a.p242c.C;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.FormatHolder;
import p007b.p225i.p226a.p242c.p243a3.SampleStream;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.TimedValueQueue;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p263t2.MpegAudioUtil;
import p007b.p225i.p226a.p242c.p265v2.CryptoConfig;
import p007b.p225i.p226a.p242c.p265v2.CryptoInfo;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;
import p007b.p225i.p226a.p242c.p266w2.FrameworkCryptoConfig;
import p007b.p225i.p226a.p242c.p278y2.BatchBuffer;
import p007b.p225i.p226a.p242c.p278y2.C2Mp3TimestampTracker;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecSelector;

/* loaded from: classes3.dex */
public abstract class MediaCodecRenderer extends BaseRenderer {

    /* renamed from: u */
    public static final byte[] f19857u = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};

    /* renamed from: A */
    public final DecoderInputBuffer f19858A;

    /* renamed from: A0 */
    public boolean f19859A0;

    /* renamed from: B */
    public final DecoderInputBuffer f19860B;

    /* renamed from: B0 */
    public boolean f19861B0;

    /* renamed from: C */
    public final BatchBuffer f19862C;

    /* renamed from: C0 */
    public long f19863C0;

    /* renamed from: D */
    public final TimedValueQueue<Format2> f19864D;

    /* renamed from: D0 */
    public long f19865D0;

    /* renamed from: E */
    public final ArrayList<Long> f19866E;

    /* renamed from: E0 */
    public boolean f19867E0;

    /* renamed from: F */
    public final MediaCodec.BufferInfo f19868F;

    /* renamed from: F0 */
    public boolean f19869F0;

    /* renamed from: G */
    public final long[] f19870G;

    /* renamed from: G0 */
    public boolean f19871G0;

    /* renamed from: H */
    public final long[] f19872H;

    /* renamed from: H0 */
    public boolean f19873H0;

    /* renamed from: I */
    public final long[] f19874I;

    /* renamed from: I0 */
    @Nullable
    public ExoPlaybackException f19875I0;

    /* renamed from: J */
    @Nullable
    public Format2 f19876J;

    /* renamed from: J0 */
    public DecoderCounters f19877J0;

    /* renamed from: K */
    @Nullable
    public Format2 f19878K;

    /* renamed from: K0 */
    public long f19879K0;

    /* renamed from: L */
    @Nullable
    public DrmSession f19880L;

    /* renamed from: L0 */
    public long f19881L0;

    /* renamed from: M */
    @Nullable
    public DrmSession f19882M;

    /* renamed from: M0 */
    public int f19883M0;

    /* renamed from: N */
    @Nullable
    public MediaCrypto f19884N;

    /* renamed from: O */
    public boolean f19885O;

    /* renamed from: P */
    public long f19886P;

    /* renamed from: Q */
    public float f19887Q;

    /* renamed from: R */
    public float f19888R;

    /* renamed from: S */
    @Nullable
    public MediaCodecAdapter f19889S;

    /* renamed from: T */
    @Nullable
    public Format2 f19890T;

    /* renamed from: U */
    @Nullable
    public MediaFormat f19891U;

    /* renamed from: V */
    public boolean f19892V;

    /* renamed from: W */
    public float f19893W;

    /* renamed from: X */
    @Nullable
    public ArrayDeque<MediaCodecInfo> f19894X;

    /* renamed from: Y */
    @Nullable
    public DecoderInitializationException f19895Y;

    /* renamed from: Z */
    @Nullable
    public MediaCodecInfo f19896Z;

    /* renamed from: a0 */
    public int f19897a0;

    /* renamed from: b0 */
    public boolean f19898b0;

    /* renamed from: c0 */
    public boolean f19899c0;

    /* renamed from: d0 */
    public boolean f19900d0;

    /* renamed from: e0 */
    public boolean f19901e0;

    /* renamed from: f0 */
    public boolean f19902f0;

    /* renamed from: g0 */
    public boolean f19903g0;

    /* renamed from: h0 */
    public boolean f19904h0;

    /* renamed from: i0 */
    public boolean f19905i0;

    /* renamed from: j0 */
    public boolean f19906j0;

    /* renamed from: k0 */
    public boolean f19907k0;

    /* renamed from: l0 */
    @Nullable
    public C2Mp3TimestampTracker f19908l0;

    /* renamed from: m0 */
    public long f19909m0;

    /* renamed from: n0 */
    public int f19910n0;

    /* renamed from: o0 */
    public int f19911o0;

    /* renamed from: p0 */
    @Nullable
    public ByteBuffer f19912p0;

    /* renamed from: q0 */
    public boolean f19913q0;

    /* renamed from: r0 */
    public boolean f19914r0;

    /* renamed from: s0 */
    public boolean f19915s0;

    /* renamed from: t0 */
    public boolean f19916t0;

    /* renamed from: u0 */
    public boolean f19917u0;

    /* renamed from: v */
    public final MediaCodecAdapter.b f19918v;

    /* renamed from: v0 */
    public boolean f19919v0;

    /* renamed from: w */
    public final MediaCodecSelector f19920w;

    /* renamed from: w0 */
    public int f19921w0;

    /* renamed from: x */
    public final boolean f19922x;

    /* renamed from: x0 */
    public int f19923x0;

    /* renamed from: y */
    public final float f19924y;

    /* renamed from: y0 */
    public int f19925y0;

    /* renamed from: z */
    public final DecoderInputBuffer f19926z;

    /* renamed from: z0 */
    public boolean f19927z0;

    public MediaCodecRenderer(int i, MediaCodecAdapter.b bVar, MediaCodecSelector mediaCodecSelector, boolean z2, float f) {
        super(i);
        this.f19918v = bVar;
        Objects.requireNonNull(mediaCodecSelector);
        this.f19920w = mediaCodecSelector;
        this.f19922x = z2;
        this.f19924y = f;
        this.f19926z = new DecoderInputBuffer(0);
        this.f19858A = new DecoderInputBuffer(0);
        this.f19860B = new DecoderInputBuffer(2);
        BatchBuffer batchBuffer = new BatchBuffer();
        this.f19862C = batchBuffer;
        this.f19864D = new TimedValueQueue<>();
        this.f19866E = new ArrayList<>();
        this.f19868F = new MediaCodec.BufferInfo();
        this.f19887Q = 1.0f;
        this.f19888R = 1.0f;
        this.f19886P = -9223372036854775807L;
        this.f19870G = new long[10];
        this.f19872H = new long[10];
        this.f19874I = new long[10];
        this.f19879K0 = -9223372036854775807L;
        this.f19881L0 = -9223372036854775807L;
        batchBuffer.m8812r(0);
        batchBuffer.f19778l.order(ByteOrder.nativeOrder());
        this.f19893W = -1.0f;
        this.f19897a0 = 0;
        this.f19921w0 = 0;
        this.f19910n0 = -1;
        this.f19911o0 = -1;
        this.f19909m0 = -9223372036854775807L;
        this.f19863C0 = -9223372036854775807L;
        this.f19865D0 = -9223372036854775807L;
        this.f19923x0 = 0;
        this.f19925y0 = 0;
    }

    @RequiresApi(23)
    /* renamed from: A0 */
    public final void m8838A0() throws ExoPlaybackException {
        try {
            this.f19884N.setMediaDrmSession(m8849X(this.f19882M).f7974c);
            m8858t0(this.f19882M);
            this.f19923x0 = 0;
            this.f19925y0 = 0;
        } catch (MediaCryptoException e) {
            throw m3550z(e, this.f19876J, false, 6006);
        }
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: B */
    public void mo2621B() {
        this.f19876J = null;
        this.f19879K0 = -9223372036854775807L;
        this.f19881L0 = -9223372036854775807L;
        this.f19883M0 = 0;
        m8847S();
    }

    /* renamed from: B0 */
    public final void m8839B0(long j) throws ExoPlaybackException {
        boolean z2;
        Format2 format2M2971f;
        Format2 format2M2970e = this.f19864D.m2970e(j);
        if (format2M2970e == null && this.f19892V) {
            TimedValueQueue<Format2> timedValueQueue = this.f19864D;
            synchronized (timedValueQueue) {
                format2M2971f = timedValueQueue.f6698d == 0 ? null : timedValueQueue.m2971f();
            }
            format2M2970e = format2M2971f;
        }
        if (format2M2970e != null) {
            this.f19878K = format2M2970e;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || (this.f19892V && this.f19878K != null)) {
            mo3167h0(this.f19878K, this.f19891U);
            this.f19892V = false;
        }
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: D */
    public void mo2622D(long j, boolean z2) throws ExoPlaybackException {
        int i;
        this.f19867E0 = false;
        this.f19869F0 = false;
        this.f19873H0 = false;
        if (this.f19915s0) {
            this.f19862C.mo3856p();
            this.f19860B.mo3856p();
            this.f19916t0 = false;
        } else if (m8847S()) {
            m8851b0();
        }
        TimedValueQueue<Format2> timedValueQueue = this.f19864D;
        synchronized (timedValueQueue) {
            i = timedValueQueue.f6698d;
        }
        if (i > 0) {
            this.f19871G0 = true;
        }
        this.f19864D.m2967b();
        int i2 = this.f19883M0;
        if (i2 != 0) {
            this.f19881L0 = this.f19872H[i2 - 1];
            this.f19879K0 = this.f19870G[i2 - 1];
            this.f19883M0 = 0;
        }
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: H */
    public void mo2623H(Format2[] format2Arr, long j, long j2) throws ExoPlaybackException {
        if (this.f19881L0 == -9223372036854775807L) {
            AnimatableValueParser.m426D(this.f19879K0 == -9223372036854775807L);
            this.f19879K0 = j;
            this.f19881L0 = j2;
            return;
        }
        int i = this.f19883M0;
        long[] jArr = this.f19872H;
        if (i == jArr.length) {
            long j3 = jArr[i - 1];
            StringBuilder sb = new StringBuilder(65);
            sb.append("Too many stream changes, so dropping offset: ");
            sb.append(j3);
            Log.w("MediaCodecRenderer", sb.toString());
        } else {
            this.f19883M0 = i + 1;
        }
        long[] jArr2 = this.f19870G;
        int i2 = this.f19883M0;
        jArr2[i2 - 1] = j;
        this.f19872H[i2 - 1] = j2;
        this.f19874I[i2 - 1] = this.f19863C0;
    }

    /* renamed from: J */
    public final boolean m8840J(long j, long j2) throws ExoPlaybackException {
        AnimatableValueParser.m426D(!this.f19869F0);
        if (this.f19862C.m3858v()) {
            BatchBuffer batchBuffer = this.f19862C;
            if (!mo3171m0(j, j2, null, batchBuffer.f19778l, this.f19911o0, 0, batchBuffer.f9097s, batchBuffer.f19780n, batchBuffer.m3554m(), this.f19862C.m3555n(), this.f19878K)) {
                return false;
            }
            mo3168i0(this.f19862C.f9096r);
            this.f19862C.mo3856p();
        }
        if (this.f19867E0) {
            this.f19869F0 = true;
            return false;
        }
        if (this.f19916t0) {
            AnimatableValueParser.m426D(this.f19862C.m3857u(this.f19860B));
            this.f19916t0 = false;
        }
        if (this.f19917u0) {
            if (this.f19862C.m3858v()) {
                return true;
            }
            m8841M();
            this.f19917u0 = false;
            m8851b0();
            if (!this.f19915s0) {
                return false;
            }
        }
        AnimatableValueParser.m426D(!this.f19867E0);
        FormatHolder formatHolderM3547A = m3547A();
        this.f19860B.mo3856p();
        while (true) {
            this.f19860B.mo3856p();
            int iM3548I = m3548I(formatHolderM3547A, this.f19860B, 0);
            if (iM3548I == -5) {
                mo3166g0(formatHolderM3547A);
                break;
            }
            if (iM3548I != -4) {
                if (iM3548I != -3) {
                    throw new IllegalStateException();
                }
            } else {
                if (this.f19860B.m3555n()) {
                    this.f19867E0 = true;
                    break;
                }
                if (this.f19871G0) {
                    Format2 format2 = this.f19876J;
                    Objects.requireNonNull(format2);
                    this.f19878K = format2;
                    mo3167h0(format2, null);
                    this.f19871G0 = false;
                }
                this.f19860B.m8813s();
                if (!this.f19862C.m3857u(this.f19860B)) {
                    this.f19916t0 = true;
                    break;
                }
            }
        }
        if (this.f19862C.m3858v()) {
            this.f19862C.m8813s();
        }
        return this.f19862C.m3858v() || this.f19867E0 || this.f19917u0;
    }

    /* renamed from: K */
    public abstract DecoderReuseEvaluation mo3144K(MediaCodecInfo mediaCodecInfo, Format2 format2, Format2 format22);

    /* renamed from: L */
    public MediaCodecDecoderException mo3146L(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(th, mediaCodecInfo);
    }

    /* renamed from: M */
    public final void m8841M() {
        this.f19917u0 = false;
        this.f19862C.mo3856p();
        this.f19860B.mo3856p();
        this.f19916t0 = false;
        this.f19915s0 = false;
    }

    /* renamed from: N */
    public final void m8842N() throws ExoPlaybackException {
        if (this.f19927z0) {
            this.f19923x0 = 1;
            this.f19925y0 = 3;
        } else {
            m8855o0();
            m8851b0();
        }
    }

    @TargetApi(23)
    /* renamed from: O */
    public final boolean m8843O() throws ExoPlaybackException {
        if (this.f19927z0) {
            this.f19923x0 = 1;
            if (this.f19899c0 || this.f19901e0) {
                this.f19925y0 = 3;
                return false;
            }
            this.f19925y0 = 2;
        } else {
            m8838A0();
        }
        return true;
    }

    /* renamed from: P */
    public final boolean m8844P(long j, long j2) throws ExoPlaybackException {
        boolean z2;
        boolean z3;
        boolean zMo3171m0;
        int iMo3838e;
        boolean z4;
        if (!(this.f19911o0 >= 0)) {
            if (this.f19902f0 && this.f19859A0) {
                try {
                    iMo3838e = this.f19889S.mo3838e(this.f19868F);
                } catch (IllegalStateException unused) {
                    m8853l0();
                    if (this.f19869F0) {
                        m8855o0();
                    }
                    return false;
                }
            } else {
                iMo3838e = this.f19889S.mo3838e(this.f19868F);
            }
            if (iMo3838e < 0) {
                if (iMo3838e != -2) {
                    if (this.f19907k0 && (this.f19867E0 || this.f19923x0 == 2)) {
                        m8853l0();
                    }
                    return false;
                }
                this.f19861B0 = true;
                MediaFormat outputFormat = this.f19889S.getOutputFormat();
                if (this.f19897a0 != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.f19906j0 = true;
                } else {
                    if (this.f19904h0) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    this.f19891U = outputFormat;
                    this.f19892V = true;
                }
                return true;
            }
            if (this.f19906j0) {
                this.f19906j0 = false;
                this.f19889S.releaseOutputBuffer(iMo3838e, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.f19868F;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                m8853l0();
                return false;
            }
            this.f19911o0 = iMo3838e;
            ByteBuffer byteBufferMo3843j = this.f19889S.mo3843j(iMo3838e);
            this.f19912p0 = byteBufferMo3843j;
            if (byteBufferMo3843j != null) {
                byteBufferMo3843j.position(this.f19868F.offset);
                ByteBuffer byteBuffer = this.f19912p0;
                MediaCodec.BufferInfo bufferInfo2 = this.f19868F;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.f19903g0) {
                MediaCodec.BufferInfo bufferInfo3 = this.f19868F;
                if (bufferInfo3.presentationTimeUs == 0 && (bufferInfo3.flags & 4) != 0) {
                    long j3 = this.f19863C0;
                    if (j3 != -9223372036854775807L) {
                        bufferInfo3.presentationTimeUs = j3;
                    }
                }
            }
            long j4 = this.f19868F.presentationTimeUs;
            int size = this.f19866E.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z4 = false;
                    break;
                }
                if (this.f19866E.get(i).longValue() == j4) {
                    this.f19866E.remove(i);
                    z4 = true;
                    break;
                }
                i++;
            }
            this.f19913q0 = z4;
            long j5 = this.f19865D0;
            long j6 = this.f19868F.presentationTimeUs;
            this.f19914r0 = j5 == j6;
            m8839B0(j6);
        }
        if (this.f19902f0 && this.f19859A0) {
            try {
                MediaCodecAdapter mediaCodecAdapter = this.f19889S;
                ByteBuffer byteBuffer2 = this.f19912p0;
                int i2 = this.f19911o0;
                MediaCodec.BufferInfo bufferInfo4 = this.f19868F;
                z3 = false;
                z2 = true;
                try {
                    zMo3171m0 = mo3171m0(j, j2, mediaCodecAdapter, byteBuffer2, i2, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.f19913q0, this.f19914r0, this.f19878K);
                } catch (IllegalStateException unused2) {
                    m8853l0();
                    if (this.f19869F0) {
                        m8855o0();
                    }
                    return z3;
                }
            } catch (IllegalStateException unused3) {
                z3 = false;
            }
        } else {
            z2 = true;
            z3 = false;
            MediaCodecAdapter mediaCodecAdapter2 = this.f19889S;
            ByteBuffer byteBuffer3 = this.f19912p0;
            int i3 = this.f19911o0;
            MediaCodec.BufferInfo bufferInfo5 = this.f19868F;
            zMo3171m0 = mo3171m0(j, j2, mediaCodecAdapter2, byteBuffer3, i3, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.f19913q0, this.f19914r0, this.f19878K);
        }
        if (zMo3171m0) {
            mo3168i0(this.f19868F.presentationTimeUs);
            boolean z5 = (this.f19868F.flags & 4) != 0;
            this.f19911o0 = -1;
            this.f19912p0 = null;
            if (!z5) {
                return z2;
            }
            m8853l0();
        }
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* renamed from: Q */
    public final boolean m8845Q() throws ExoPlaybackException {
        MediaCodecAdapter mediaCodecAdapter = this.f19889S;
        boolean z2 = 0;
        if (mediaCodecAdapter == null || this.f19923x0 == 2 || this.f19867E0) {
            return false;
        }
        if (this.f19910n0 < 0) {
            int iMo3837d = mediaCodecAdapter.mo3837d();
            this.f19910n0 = iMo3837d;
            if (iMo3837d < 0) {
                return false;
            }
            this.f19858A.f19778l = this.f19889S.mo3841h(iMo3837d);
            this.f19858A.mo3856p();
        }
        if (this.f19923x0 == 1) {
            if (!this.f19907k0) {
                this.f19859A0 = true;
                this.f19889S.queueInputBuffer(this.f19910n0, 0, 0, 0L, 4);
                m8857s0();
            }
            this.f19923x0 = 2;
            return false;
        }
        if (this.f19905i0) {
            this.f19905i0 = false;
            ByteBuffer byteBuffer = this.f19858A.f19778l;
            byte[] bArr = f19857u;
            byteBuffer.put(bArr);
            this.f19889S.queueInputBuffer(this.f19910n0, 0, bArr.length, 0L, 0);
            m8857s0();
            this.f19927z0 = true;
            return true;
        }
        if (this.f19921w0 == 1) {
            for (int i = 0; i < this.f19890T.f7157y.size(); i++) {
                this.f19858A.f19778l.put(this.f19890T.f7157y.get(i));
            }
            this.f19921w0 = 2;
        }
        int iPosition = this.f19858A.f19778l.position();
        FormatHolder formatHolderM3547A = m3547A();
        try {
            int iM3548I = m3548I(formatHolderM3547A, this.f19858A, 0);
            if (mo2935j()) {
                this.f19865D0 = this.f19863C0;
            }
            if (iM3548I == -3) {
                return false;
            }
            if (iM3548I == -5) {
                if (this.f19921w0 == 2) {
                    this.f19858A.mo3856p();
                    this.f19921w0 = 1;
                }
                mo3166g0(formatHolderM3547A);
                return true;
            }
            if (this.f19858A.m3555n()) {
                if (this.f19921w0 == 2) {
                    this.f19858A.mo3856p();
                    this.f19921w0 = 1;
                }
                this.f19867E0 = true;
                if (!this.f19927z0) {
                    m8853l0();
                    return false;
                }
                try {
                    if (!this.f19907k0) {
                        this.f19859A0 = true;
                        this.f19889S.queueInputBuffer(this.f19910n0, 0, 0, 0L, 4);
                        m8857s0();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw m3550z(e, this.f19876J, false, Util2.m3008p(e.getErrorCode()));
                }
            }
            if (!this.f19927z0 && !this.f19858A.m3556o()) {
                this.f19858A.mo3856p();
                if (this.f19921w0 == 2) {
                    this.f19921w0 = 1;
                }
                return true;
            }
            boolean zM8814t = this.f19858A.m8814t();
            if (zM8814t) {
                CryptoInfo cryptoInfo = this.f19858A.f19777k;
                Objects.requireNonNull(cryptoInfo);
                if (iPosition != 0) {
                    if (cryptoInfo.f7905d == null) {
                        int[] iArr = new int[1];
                        cryptoInfo.f7905d = iArr;
                        cryptoInfo.f7910i.numBytesOfClearData = iArr;
                    }
                    int[] iArr2 = cryptoInfo.f7905d;
                    iArr2[0] = iArr2[0] + iPosition;
                }
            }
            if (this.f19898b0 && !zM8814t) {
                ByteBuffer byteBuffer2 = this.f19858A.f19778l;
                byte[] bArr2 = NalUnitUtil.f6753a;
                int iPosition2 = byteBuffer2.position();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i2 + 1;
                    if (i4 >= iPosition2) {
                        byteBuffer2.clear();
                        break;
                    }
                    int i5 = byteBuffer2.get(i2) & 255;
                    if (i3 == 3) {
                        if (i5 == 1 && (byteBuffer2.get(i4) & 31) == 7) {
                            ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
                            byteBufferDuplicate.position(i2 - 3);
                            byteBufferDuplicate.limit(iPosition2);
                            byteBuffer2.position(0);
                            byteBuffer2.put(byteBufferDuplicate);
                            break;
                        }
                    } else if (i5 == 0) {
                        i3++;
                    }
                    if (i5 != 0) {
                        i3 = 0;
                    }
                    i2 = i4;
                }
                if (this.f19858A.f19778l.position() == 0) {
                    return true;
                }
                this.f19898b0 = false;
            }
            DecoderInputBuffer decoderInputBuffer = this.f19858A;
            long j = decoderInputBuffer.f19780n;
            C2Mp3TimestampTracker c2Mp3TimestampTracker = this.f19908l0;
            if (c2Mp3TimestampTracker != null) {
                Format2 format2 = this.f19876J;
                if (c2Mp3TimestampTracker.f9100b == 0) {
                    c2Mp3TimestampTracker.f9099a = j;
                }
                if (!c2Mp3TimestampTracker.f9101c) {
                    ByteBuffer byteBuffer3 = decoderInputBuffer.f19778l;
                    Objects.requireNonNull(byteBuffer3);
                    int i6 = 0;
                    for (int i7 = 0; i7 < 4; i7++) {
                        i6 = (i6 << 8) | (byteBuffer3.get(i7) & 255);
                    }
                    int iM3468d = MpegAudioUtil.m3468d(i6);
                    if (iM3468d == -1) {
                        c2Mp3TimestampTracker.f9101c = true;
                        c2Mp3TimestampTracker.f9100b = 0L;
                        c2Mp3TimestampTracker.f9099a = decoderInputBuffer.f19780n;
                        Log.w("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
                        j = decoderInputBuffer.f19780n;
                    } else {
                        long jM3859a = c2Mp3TimestampTracker.m3859a(format2.f7137K);
                        c2Mp3TimestampTracker.f9100b += iM3468d;
                        j = jM3859a;
                    }
                }
                long j2 = this.f19863C0;
                C2Mp3TimestampTracker c2Mp3TimestampTracker2 = this.f19908l0;
                Format2 format22 = this.f19876J;
                Objects.requireNonNull(c2Mp3TimestampTracker2);
                this.f19863C0 = Math.max(j2, c2Mp3TimestampTracker2.m3859a(format22.f7137K));
            }
            long j3 = j;
            if (this.f19858A.m3554m()) {
                this.f19866E.add(Long.valueOf(j3));
            }
            if (this.f19871G0) {
                this.f19864D.m2966a(j3, this.f19876J);
                this.f19871G0 = false;
            }
            this.f19863C0 = Math.max(this.f19863C0, j3);
            this.f19858A.m8813s();
            if (this.f19858A.m3553l()) {
                mo3162Z(this.f19858A);
            }
            mo3170k0(this.f19858A);
            try {
                if (zM8814t) {
                    this.f19889S.mo3835b(this.f19910n0, 0, this.f19858A.f19777k, j3, 0);
                } else {
                    this.f19889S.queueInputBuffer(this.f19910n0, 0, this.f19858A.f19778l.limit(), j3, 0);
                }
                m8857s0();
                this.f19927z0 = true;
                this.f19921w0 = 0;
                DecoderCounters decoderCounters = this.f19877J0;
                z2 = decoderCounters.f7916c + 1;
                decoderCounters.f7916c = z2;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                throw m3550z(e2, this.f19876J, z2, Util2.m3008p(e2.getErrorCode()));
            }
        } catch (DecoderInputBuffer.InsufficientCapacityException e3) {
            mo3163d0(e3);
            m8854n0(0);
            m8846R();
            return true;
        }
    }

    /* renamed from: R */
    public final void m8846R() {
        try {
            this.f19889S.flush();
        } finally {
            mo3172q0();
        }
    }

    /* renamed from: S */
    public boolean m8847S() {
        if (this.f19889S == null) {
            return false;
        }
        if (this.f19925y0 == 3 || this.f19899c0 || ((this.f19900d0 && !this.f19861B0) || (this.f19901e0 && this.f19859A0))) {
            m8855o0();
            return true;
        }
        m8846R();
        return false;
    }

    /* renamed from: T */
    public final List<MediaCodecInfo> m8848T(boolean z2) throws MediaCodecUtil.DecoderQueryException {
        List<MediaCodecInfo> listMo3160W = mo3160W(this.f19920w, this.f19876J, z2);
        if (listMo3160W.isEmpty() && z2) {
            listMo3160W = mo3160W(this.f19920w, this.f19876J, false);
            if (!listMo3160W.isEmpty()) {
                String str = this.f19876J.f7155w;
                String strValueOf = String.valueOf(listMo3160W);
                outline.m874r0(outline.m831S(strValueOf.length() + outline.m841b(str, 99), "Drm session requires secure decoder for ", str, ", but no secure decoder available. Trying to proceed with ", strValueOf), ".", "MediaCodecRenderer");
            }
        }
        return listMo3160W;
    }

    /* renamed from: U */
    public boolean mo3156U() {
        return false;
    }

    /* renamed from: V */
    public abstract float mo3158V(float f, Format2 format2, Format2[] format2Arr);

    /* renamed from: W */
    public abstract List<MediaCodecInfo> mo3160W(MediaCodecSelector mediaCodecSelector, Format2 format2, boolean z2) throws MediaCodecUtil.DecoderQueryException;

    @Nullable
    /* renamed from: X */
    public final FrameworkCryptoConfig m8849X(DrmSession drmSession) throws ExoPlaybackException {
        CryptoConfig cryptoConfigMo3612g = drmSession.mo3612g();
        if (cryptoConfigMo3612g == null || (cryptoConfigMo3612g instanceof FrameworkCryptoConfig)) {
            return (FrameworkCryptoConfig) cryptoConfigMo3612g;
        }
        String strValueOf = String.valueOf(cryptoConfigMo3612g);
        throw m3550z(new IllegalArgumentException(outline.m857j(strValueOf.length() + 43, "Expecting FrameworkCryptoConfig but found: ", strValueOf)), this.f19876J, false, 6001);
    }

    /* renamed from: Y */
    public abstract MediaCodecAdapter.a mo3161Y(MediaCodecInfo mediaCodecInfo, Format2 format2, @Nullable MediaCrypto mediaCrypto, float f);

    /* renamed from: Z */
    public void mo3162Z(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    @Override // p007b.p225i.p226a.p242c.RendererCapabilities
    /* renamed from: a */
    public final int mo2630a(Format2 format2) throws ExoPlaybackException {
        try {
            return mo3174y0(this.f19920w, format2);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw m3549y(e, format2, 4002);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015e  */
    /* renamed from: a0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8850a0(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto) throws Exception {
        float fMo3158V;
        int i;
        boolean z2;
        boolean z3;
        String str = mediaCodecInfo.f9112a;
        int i2 = Util2.f6708a;
        if (i2 < 23) {
            fMo3158V = -1.0f;
        } else {
            float f = this.f19888R;
            Format2 format2 = this.f19876J;
            Format2[] format2Arr = this.f7895p;
            Objects.requireNonNull(format2Arr);
            fMo3158V = mo3158V(f, format2, format2Arr);
        }
        float f2 = fMo3158V > this.f19924y ? fMo3158V : -1.0f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strValueOf = String.valueOf(str);
        AnimatableValueParser.m515f(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
        this.f19889S = this.f19918v.mo3845a(mo3161Y(mediaCodecInfo, this.f19876J, mediaCrypto, f2));
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        this.f19896Z = mediaCodecInfo;
        this.f19893W = f2;
        this.f19890T = this.f19876J;
        if (i2 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = Util2.f6711d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                i = 2;
            }
        } else if (i2 >= 24 || !("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str))) {
            i = 0;
        } else {
            String str3 = Util2.f6709b;
            if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
                i = 1;
            }
        }
        this.f19897a0 = i;
        this.f19898b0 = i2 < 21 && this.f19890T.f7157y.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
        this.f19899c0 = i2 < 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i2 == 19 && Util2.f6711d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
        this.f19900d0 = i2 == 29 && "c2.android.aac.decoder".equals(str);
        if (i2 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i2 <= 19) {
                String str4 = Util2.f6709b;
                z2 = ("hb2000".equals(str4) || "stvm8".equals(str4)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str));
            }
        }
        this.f19901e0 = z2;
        this.f19902f0 = i2 == 21 && "OMX.google.aac.decoder".equals(str);
        if (i2 < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(Util2.f6710c)) {
            String str5 = Util2.f6709b;
            if (str5.startsWith("baffin") || str5.startsWith("grand") || str5.startsWith("fortuna") || str5.startsWith("gprimelte") || str5.startsWith("j2y18lte") || str5.startsWith("ms01")) {
                z3 = true;
            }
        } else {
            z3 = false;
        }
        this.f19903g0 = z3;
        this.f19904h0 = i2 <= 18 && this.f19890T.f7136J == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
        String str6 = mediaCodecInfo.f9112a;
        this.f19907k0 = ((i2 <= 25 && "OMX.rk.video_decoder.avc".equals(str6)) || ((i2 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str6)) || ((i2 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str6) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str6))) || ("Amazon".equals(Util2.f6710c) && "AFTS".equals(Util2.f6711d) && mediaCodecInfo.f9117f)))) || mo3156U();
        if (this.f19889S.mo3834a()) {
            this.f19919v0 = true;
            this.f19921w0 = 1;
            this.f19905i0 = this.f19897a0 != 0;
        }
        if ("c2.android.mp3.decoder".equals(mediaCodecInfo.f9112a)) {
            this.f19908l0 = new C2Mp3TimestampTracker();
        }
        if (this.f7893n == 2) {
            this.f19909m0 = SystemClock.elapsedRealtime() + 1000;
        }
        this.f19877J0.f7914a++;
        mo3164e0(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: b */
    public boolean mo2631b() {
        return this.f19869F0;
    }

    /* renamed from: b0 */
    public final void m8851b0() throws ExoPlaybackException {
        Format2 format2;
        if (this.f19889S != null || this.f19915s0 || (format2 = this.f19876J) == null) {
            return;
        }
        if (this.f19882M == null && mo3516x0(format2)) {
            Format2 format22 = this.f19876J;
            m8841M();
            String str = format22.f7155w;
            if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                BatchBuffer batchBuffer = this.f19862C;
                Objects.requireNonNull(batchBuffer);
                AnimatableValueParser.m531j(true);
                batchBuffer.f9098t = 32;
            } else {
                BatchBuffer batchBuffer2 = this.f19862C;
                Objects.requireNonNull(batchBuffer2);
                AnimatableValueParser.m531j(true);
                batchBuffer2.f9098t = 1;
            }
            this.f19915s0 = true;
            return;
        }
        m8858t0(this.f19882M);
        String str2 = this.f19876J.f7155w;
        DrmSession drmSession = this.f19880L;
        if (drmSession != null) {
            if (this.f19884N == null) {
                FrameworkCryptoConfig frameworkCryptoConfigM8849X = m8849X(drmSession);
                if (frameworkCryptoConfigM8849X != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(frameworkCryptoConfigM8849X.f7973b, frameworkCryptoConfigM8849X.f7974c);
                        this.f19884N = mediaCrypto;
                        this.f19885O = !frameworkCryptoConfigM8849X.f7975d && mediaCrypto.requiresSecureDecoderComponent(str2);
                    } catch (MediaCryptoException e) {
                        throw m3550z(e, this.f19876J, false, 6006);
                    }
                } else if (this.f19880L.mo3611f() == null) {
                    return;
                }
            }
            if (FrameworkCryptoConfig.f7972a) {
                int state = this.f19880L.getState();
                if (state == 1) {
                    DrmSession.DrmSessionException drmSessionExceptionMo3611f = this.f19880L.mo3611f();
                    Objects.requireNonNull(drmSessionExceptionMo3611f);
                    throw m3550z(drmSessionExceptionMo3611f, this.f19876J, false, drmSessionExceptionMo3611f.errorCode);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            m8852c0(this.f19884N, this.f19885O);
        } catch (DecoderInitializationException e2) {
            throw m3550z(e2, this.f19876J, false, 4001);
        }
    }

    /* renamed from: c0 */
    public final void m8852c0(MediaCrypto mediaCrypto, boolean z2) throws DecoderInitializationException {
        if (this.f19894X == null) {
            try {
                List<MediaCodecInfo> listM8848T = m8848T(z2);
                ArrayDeque<MediaCodecInfo> arrayDeque = new ArrayDeque<>();
                this.f19894X = arrayDeque;
                if (this.f19922x) {
                    arrayDeque.addAll(listM8848T);
                } else if (!listM8848T.isEmpty()) {
                    this.f19894X.add(listM8848T.get(0));
                }
                this.f19895Y = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(this.f19876J, e, z2, -49998);
            }
        }
        if (this.f19894X.isEmpty()) {
            throw new DecoderInitializationException(this.f19876J, null, z2, -49999);
        }
        while (this.f19889S == null) {
            MediaCodecInfo mediaCodecInfoPeekFirst = this.f19894X.peekFirst();
            if (!mo3173w0(mediaCodecInfoPeekFirst)) {
                return;
            }
            try {
                m8850a0(mediaCodecInfoPeekFirst, mediaCrypto);
            } catch (Exception e2) {
                String strValueOf = String.valueOf(mediaCodecInfoPeekFirst);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 30);
                sb.append("Failed to initialize decoder: ");
                sb.append(strValueOf);
                Log2.m3040c("MediaCodecRenderer", sb.toString(), e2);
                this.f19894X.removeFirst();
                Format2 format2 = this.f19876J;
                String str = mediaCodecInfoPeekFirst.f9112a;
                String strValueOf2 = String.valueOf(format2);
                DecoderInitializationException decoderInitializationException = new DecoderInitializationException(outline.m861l(strValueOf2.length() + outline.m841b(str, 23), "Decoder init failed: ", str, ", ", strValueOf2), e2, format2.f7155w, z2, mediaCodecInfoPeekFirst, (Util2.f6708a < 21 || !(e2 instanceof MediaCodec.CodecException)) ? null : ((MediaCodec.CodecException) e2).getDiagnosticInfo(), null);
                mo3163d0(decoderInitializationException);
                DecoderInitializationException decoderInitializationException2 = this.f19895Y;
                if (decoderInitializationException2 == null) {
                    this.f19895Y = decoderInitializationException;
                } else {
                    this.f19895Y = new DecoderInitializationException(decoderInitializationException2.getMessage(), decoderInitializationException2.getCause(), decoderInitializationException2.mimeType, decoderInitializationException2.secureDecoderRequired, decoderInitializationException2.codecInfo, decoderInitializationException2.diagnosticInfo, decoderInitializationException);
                }
                if (this.f19894X.isEmpty()) {
                    throw this.f19895Y;
                }
            }
        }
        this.f19894X = null;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: d */
    public boolean mo2632d() {
        boolean zMo2508d;
        if (this.f19876J == null) {
            return false;
        }
        if (mo2935j()) {
            zMo2508d = this.f7898s;
        } else {
            SampleStream sampleStream = this.f7894o;
            Objects.requireNonNull(sampleStream);
            zMo2508d = sampleStream.mo2508d();
        }
        if (!zMo2508d) {
            if (!(this.f19911o0 >= 0) && (this.f19909m0 == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.f19909m0)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d0 */
    public abstract void mo3163d0(Exception exc);

    /* renamed from: e0 */
    public abstract void mo3164e0(String str, long j, long j2);

    /* renamed from: f0 */
    public abstract void mo3165f0(String str);

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f3  */
    @Nullable
    @CallSuper
    /* renamed from: g0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DecoderReuseEvaluation mo3166g0(FormatHolder formatHolder) throws ExoPlaybackException {
        FrameworkCryptoConfig frameworkCryptoConfigM8849X;
        boolean z2;
        boolean z3 = true;
        this.f19871G0 = true;
        Format2 format2 = formatHolder.f7196b;
        Objects.requireNonNull(format2);
        if (format2.f7155w == null) {
            throw m3550z(new IllegalArgumentException(), format2, false, 4005);
        }
        m8859u0(formatHolder.f7195a);
        this.f19876J = format2;
        if (this.f19915s0) {
            this.f19917u0 = true;
            return null;
        }
        MediaCodecAdapter mediaCodecAdapter = this.f19889S;
        if (mediaCodecAdapter == null) {
            this.f19894X = null;
            m8851b0();
            return null;
        }
        MediaCodecInfo mediaCodecInfo = this.f19896Z;
        Format2 format22 = this.f19890T;
        DrmSession drmSession = this.f19880L;
        DrmSession drmSession2 = this.f19882M;
        if (drmSession != drmSession2) {
            if (drmSession2 != null && drmSession != null && Util2.f6708a >= 23) {
                UUID uuid = C.f8025e;
                if (!uuid.equals(drmSession.mo3608c()) && !uuid.equals(drmSession2.mo3608c()) && (frameworkCryptoConfigM8849X = m8849X(drmSession2)) != null) {
                    z2 = !mediaCodecInfo.f9117f && (frameworkCryptoConfigM8849X.f7975d ? false : drmSession2.mo3610e(format2.f7155w));
                }
            }
        }
        if (z2) {
            m8842N();
            return new DecoderReuseEvaluation(mediaCodecInfo.f9112a, format22, format2, 0, 128);
        }
        boolean z4 = this.f19882M != this.f19880L;
        AnimatableValueParser.m426D(!z4 || Util2.f6708a >= 23);
        DecoderReuseEvaluation decoderReuseEvaluationMo3144K = mo3144K(mediaCodecInfo, format22, format2);
        int i = decoderReuseEvaluationMo3144K.f7929d;
        int i2 = 2;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    if (m8861z0(format2)) {
                        this.f19890T = format2;
                        if (!z4 || m8843O()) {
                        }
                    } else {
                        i2 = 16;
                    }
                } else if (m8861z0(format2)) {
                    this.f19919v0 = true;
                    this.f19921w0 = 1;
                    int i3 = this.f19897a0;
                    if (i3 != 2 && (i3 != 1 || format2.f7128B != format22.f7128B || format2.f7129C != format22.f7129C)) {
                        z3 = false;
                    }
                    this.f19905i0 = z3;
                    this.f19890T = format2;
                    if (!z4 || m8843O()) {
                    }
                }
            } else if (m8861z0(format2)) {
                this.f19890T = format2;
                if (!z4) {
                    if (this.f19927z0) {
                        this.f19923x0 = 1;
                        if (this.f19899c0 || this.f19901e0) {
                            this.f19925y0 = 3;
                            z3 = false;
                        } else {
                            this.f19925y0 = 1;
                        }
                    }
                    if (z3) {
                    }
                } else if (m8843O()) {
                }
            }
            return (decoderReuseEvaluationMo3144K.f7929d != 0 || (this.f19889S == mediaCodecAdapter && this.f19925y0 != 3)) ? decoderReuseEvaluationMo3144K : new DecoderReuseEvaluation(mediaCodecInfo.f9112a, format22, format2, 0, i2);
        }
        m8842N();
        i2 = 0;
        if (decoderReuseEvaluationMo3144K.f7929d != 0) {
        }
    }

    /* renamed from: h0 */
    public abstract void mo3167h0(Format2 format2, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException;

    @CallSuper
    /* renamed from: i0 */
    public void mo3168i0(long j) {
        while (true) {
            int i = this.f19883M0;
            if (i == 0 || j < this.f19874I[0]) {
                return;
            }
            long[] jArr = this.f19870G;
            this.f19879K0 = jArr[0];
            this.f19881L0 = this.f19872H[0];
            int i2 = i - 1;
            this.f19883M0 = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.f19872H;
            System.arraycopy(jArr2, 1, jArr2, 0, this.f19883M0);
            long[] jArr3 = this.f19874I;
            System.arraycopy(jArr3, 1, jArr3, 0, this.f19883M0);
            mo3169j0();
        }
    }

    /* renamed from: j0 */
    public abstract void mo3169j0();

    /* renamed from: k0 */
    public abstract void mo3170k0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException;

    @TargetApi(23)
    /* renamed from: l0 */
    public final void m8853l0() throws ExoPlaybackException {
        int i = this.f19925y0;
        if (i == 1) {
            m8846R();
            return;
        }
        if (i == 2) {
            m8846R();
            m8838A0();
        } else if (i != 3) {
            this.f19869F0 = true;
            mo3515p0();
        } else {
            m8855o0();
            m8851b0();
        }
    }

    /* renamed from: m0 */
    public abstract boolean mo3171m0(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z2, boolean z3, Format2 format2) throws ExoPlaybackException;

    @Override // p007b.p225i.p226a.p242c.BaseRenderer, p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: n */
    public void mo2939n(float f, float f2) throws ExoPlaybackException {
        this.f19887Q = f;
        this.f19888R = f2;
        m8861z0(this.f19890T);
    }

    /* renamed from: n0 */
    public final boolean m8854n0(int i) throws ExoPlaybackException {
        FormatHolder formatHolderM3547A = m3547A();
        this.f19926z.mo3856p();
        int iM3548I = m3548I(formatHolderM3547A, this.f19926z, i | 4);
        if (iM3548I == -5) {
            mo3166g0(formatHolderM3547A);
            return true;
        }
        if (iM3548I != -4 || !this.f19926z.m3555n()) {
            return false;
        }
        this.f19867E0 = true;
        m8853l0();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: o0 */
    public void m8855o0() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.f19889S;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
                this.f19877J0.f7915b++;
                mo3165f0(this.f19896Z.f9112a);
            }
            this.f19889S = null;
            try {
                MediaCrypto mediaCrypto = this.f19884N;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.f19889S = null;
            try {
                MediaCrypto mediaCrypto2 = this.f19884N;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer, p007b.p225i.p226a.p242c.RendererCapabilities
    /* renamed from: p */
    public final int mo3119p() {
        return 8;
    }

    /* renamed from: p0 */
    public void mo3515p0() throws ExoPlaybackException {
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a1  */
    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo2633q(long j, long j2) throws ExoPlaybackException {
        boolean z2;
        boolean z3 = false;
        if (this.f19873H0) {
            this.f19873H0 = false;
            m8853l0();
        }
        ExoPlaybackException exoPlaybackException = this.f19875I0;
        if (exoPlaybackException != null) {
            this.f19875I0 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.f19869F0) {
                mo3515p0();
                return;
            }
            if (this.f19876J != null || m8854n0(2)) {
                m8851b0();
                if (this.f19915s0) {
                    AnimatableValueParser.m515f("bypassRender");
                    while (m8840J(j, j2)) {
                    }
                    AnimatableValueParser.m508d0();
                } else if (this.f19889S != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    AnimatableValueParser.m515f("drainAndFeed");
                    while (m8844P(j, j2) && m8860v0(jElapsedRealtime)) {
                    }
                    while (m8845Q() && m8860v0(jElapsedRealtime)) {
                    }
                    AnimatableValueParser.m508d0();
                } else {
                    DecoderCounters decoderCounters = this.f19877J0;
                    int i = decoderCounters.f7917d;
                    SampleStream sampleStream = this.f7894o;
                    Objects.requireNonNull(sampleStream);
                    decoderCounters.f7917d = i + sampleStream.mo2507c(j - this.f7896q);
                    m8854n0(1);
                }
                synchronized (this.f19877J0) {
                }
            }
        } catch (IllegalStateException e) {
            int i2 = Util2.f6708a;
            if (i2 < 21 || !(e instanceof MediaCodec.CodecException)) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                z2 = stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
            }
            if (!z2) {
                throw e;
            }
            mo3163d0(e);
            if (i2 >= 21) {
                if (e instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) e).isRecoverable() : false) {
                    z3 = true;
                }
            }
            if (z3) {
                m8855o0();
            }
            throw m3550z(mo3146L(e, this.f19896Z), this.f19876J, z3, 4003);
        }
    }

    @CallSuper
    /* renamed from: q0 */
    public void mo3172q0() {
        m8857s0();
        this.f19911o0 = -1;
        this.f19912p0 = null;
        this.f19909m0 = -9223372036854775807L;
        this.f19859A0 = false;
        this.f19927z0 = false;
        this.f19905i0 = false;
        this.f19906j0 = false;
        this.f19913q0 = false;
        this.f19914r0 = false;
        this.f19866E.clear();
        this.f19863C0 = -9223372036854775807L;
        this.f19865D0 = -9223372036854775807L;
        C2Mp3TimestampTracker c2Mp3TimestampTracker = this.f19908l0;
        if (c2Mp3TimestampTracker != null) {
            c2Mp3TimestampTracker.f9099a = 0L;
            c2Mp3TimestampTracker.f9100b = 0L;
            c2Mp3TimestampTracker.f9101c = false;
        }
        this.f19923x0 = 0;
        this.f19925y0 = 0;
        this.f19921w0 = this.f19919v0 ? 1 : 0;
    }

    @CallSuper
    /* renamed from: r0 */
    public void m8856r0() {
        mo3172q0();
        this.f19875I0 = null;
        this.f19908l0 = null;
        this.f19894X = null;
        this.f19896Z = null;
        this.f19890T = null;
        this.f19891U = null;
        this.f19892V = false;
        this.f19861B0 = false;
        this.f19893W = -1.0f;
        this.f19897a0 = 0;
        this.f19898b0 = false;
        this.f19899c0 = false;
        this.f19900d0 = false;
        this.f19901e0 = false;
        this.f19902f0 = false;
        this.f19903g0 = false;
        this.f19904h0 = false;
        this.f19907k0 = false;
        this.f19919v0 = false;
        this.f19921w0 = 0;
        this.f19885O = false;
    }

    /* renamed from: s0 */
    public final void m8857s0() {
        this.f19910n0 = -1;
        this.f19858A.f19778l = null;
    }

    /* renamed from: t0 */
    public final void m8858t0(@Nullable DrmSession drmSession) {
        DrmSession drmSession2 = this.f19880L;
        if (drmSession2 != drmSession) {
            if (drmSession != null) {
                drmSession.mo3606a(null);
            }
            if (drmSession2 != null) {
                drmSession2.mo3607b(null);
            }
        }
        this.f19880L = drmSession;
    }

    /* renamed from: u0 */
    public final void m8859u0(@Nullable DrmSession drmSession) {
        DrmSession drmSession2 = this.f19882M;
        if (drmSession2 != drmSession) {
            if (drmSession != null) {
                drmSession.mo3606a(null);
            }
            if (drmSession2 != null) {
                drmSession2.mo3607b(null);
            }
        }
        this.f19882M = drmSession;
    }

    /* renamed from: v0 */
    public final boolean m8860v0(long j) {
        return this.f19886P == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.f19886P;
    }

    /* renamed from: w0 */
    public boolean mo3173w0(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    /* renamed from: x0 */
    public boolean mo3516x0(Format2 format2) {
        return false;
    }

    /* renamed from: y0 */
    public abstract int mo3174y0(MediaCodecSelector mediaCodecSelector, Format2 format2) throws MediaCodecUtil.DecoderQueryException;

    /* renamed from: z0 */
    public final boolean m8861z0(Format2 format2) throws ExoPlaybackException {
        if (Util2.f6708a >= 23 && this.f19889S != null && this.f19925y0 != 3 && this.f7893n != 0) {
            float f = this.f19888R;
            Format2[] format2Arr = this.f7895p;
            Objects.requireNonNull(format2Arr);
            float fMo3158V = mo3158V(f, format2, format2Arr);
            float f2 = this.f19893W;
            if (f2 == fMo3158V) {
                return true;
            }
            if (fMo3158V == -1.0f) {
                m8842N();
                return false;
            }
            if (f2 == -1.0f && fMo3158V <= this.f19924y) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fMo3158V);
            this.f19889S.setParameters(bundle);
            this.f19893W = fMo3158V;
        }
        return true;
    }

    public static class DecoderInitializationException extends Exception {

        @Nullable
        public final MediaCodecInfo codecInfo;

        @Nullable
        public final String diagnosticInfo;

        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format2 format2, @Nullable Throwable th, boolean z2, int i) {
            String strValueOf = String.valueOf(format2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
            sb.append("Decoder init failed: [");
            sb.append(i);
            sb.append("], ");
            sb.append(strValueOf);
            String string = sb.toString();
            String str = format2.f7155w;
            String str2 = i < 0 ? "neg_" : "";
            int iAbs = Math.abs(i);
            StringBuilder sb2 = new StringBuilder(str2.length() + 71);
            sb2.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
            sb2.append(str2);
            sb2.append(iAbs);
            this(string, th, str, z2, null, sb2.toString(), null);
        }

        public DecoderInitializationException(String str, @Nullable Throwable th, String str2, boolean z2, @Nullable MediaCodecInfo mediaCodecInfo, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z2;
            this.codecInfo = mediaCodecInfo;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }
    }
}
