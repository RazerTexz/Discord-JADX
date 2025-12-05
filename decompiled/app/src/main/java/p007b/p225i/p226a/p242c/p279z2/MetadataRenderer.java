package p007b.p225i.p226a.p242c.p279z2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.BaseRenderer;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.FormatHolder;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: MetadataRenderer.java */
/* renamed from: b.i.a.c.z2.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {

    /* renamed from: A */
    public boolean f9138A;

    /* renamed from: B */
    public long f9139B;

    /* renamed from: C */
    public long f9140C;

    /* renamed from: D */
    @Nullable
    public Metadata f9141D;

    /* renamed from: u */
    public final MetadataDecoderFactory f9142u;

    /* renamed from: v */
    public final MetadataOutput f9143v;

    /* renamed from: w */
    @Nullable
    public final Handler f9144w;

    /* renamed from: x */
    public final MetadataInputBuffer f9145x;

    /* renamed from: y */
    @Nullable
    public MetadataDecoder f9146y;

    /* renamed from: z */
    public boolean f9147z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper) {
        Handler handler;
        super(5);
        MetadataDecoderFactory metadataDecoderFactory = MetadataDecoderFactory.f9136a;
        Objects.requireNonNull(metadataOutput);
        this.f9143v = metadataOutput;
        if (looper == null) {
            handler = null;
        } else {
            int i = Util2.f6708a;
            handler = new Handler(looper, this);
        }
        this.f9144w = handler;
        this.f9142u = metadataDecoderFactory;
        this.f9145x = new MetadataInputBuffer();
        this.f9140C = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: B */
    public void mo2621B() {
        this.f9141D = null;
        this.f9140C = -9223372036854775807L;
        this.f9146y = null;
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: D */
    public void mo2622D(long j, boolean z2) {
        this.f9141D = null;
        this.f9140C = -9223372036854775807L;
        this.f9147z = false;
        this.f9138A = false;
    }

    @Override // p007b.p225i.p226a.p242c.BaseRenderer
    /* renamed from: H */
    public void mo2623H(Format2[] format2Arr, long j, long j2) {
        this.f9146y = this.f9142u.mo3897b(format2Arr[0]);
    }

    /* renamed from: J */
    public final void m3898J(Metadata metadata, List<Metadata.Entry> list) {
        int i = 0;
        while (true) {
            Metadata.Entry[] entryArr = metadata.f19936j;
            if (i >= entryArr.length) {
                return;
            }
            Format2 format2Mo8880y = entryArr[i].mo8880y();
            if (format2Mo8880y == null || !this.f9142u.mo3896a(format2Mo8880y)) {
                list.add(metadata.f19936j[i]);
            } else {
                MetadataDecoder metadataDecoderMo3897b = this.f9142u.mo3897b(format2Mo8880y);
                byte[] bArrMo8879o0 = metadata.f19936j[i].mo8879o0();
                Objects.requireNonNull(bArrMo8879o0);
                this.f9145x.mo3856p();
                this.f9145x.m8812r(bArrMo8879o0.length);
                ByteBuffer byteBuffer = this.f9145x.f19778l;
                int i2 = Util2.f6708a;
                byteBuffer.put(bArrMo8879o0);
                this.f9145x.m8813s();
                Metadata metadataMo3895a = metadataDecoderMo3897b.mo3895a(this.f9145x);
                if (metadataMo3895a != null) {
                    m3898J(metadataMo3895a, list);
                }
            }
            i++;
        }
    }

    @Override // p007b.p225i.p226a.p242c.RendererCapabilities
    /* renamed from: a */
    public int mo2630a(Format2 format2) {
        if (this.f9142u.mo3896a(format2)) {
            return (format2.f7142P == 0 ? 4 : 2) | 0 | 0;
        }
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: b */
    public boolean mo2631b() {
        return this.f9138A;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: d */
    public boolean mo2632d() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2, p007b.p225i.p226a.p242c.RendererCapabilities
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.f9143v.mo3298b((Metadata) message.obj);
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: q */
    public void mo2633q(long j, long j2) {
        boolean z2 = true;
        while (z2) {
            if (!this.f9147z && this.f9141D == null) {
                this.f9145x.mo3856p();
                FormatHolder formatHolderM3547A = m3547A();
                int iM3548I = m3548I(formatHolderM3547A, this.f9145x, 0);
                if (iM3548I == -4) {
                    if (this.f9145x.m3555n()) {
                        this.f9147z = true;
                    } else {
                        MetadataInputBuffer metadataInputBuffer = this.f9145x;
                        metadataInputBuffer.f9137r = this.f9139B;
                        metadataInputBuffer.m8813s();
                        MetadataDecoder metadataDecoder = this.f9146y;
                        int i = Util2.f6708a;
                        Metadata metadataMo3895a = metadataDecoder.mo3895a(this.f9145x);
                        if (metadataMo3895a != null) {
                            ArrayList arrayList = new ArrayList(metadataMo3895a.f19936j.length);
                            m3898J(metadataMo3895a, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.f9141D = new Metadata(arrayList);
                                this.f9140C = this.f9145x.f19780n;
                            }
                        }
                    }
                } else if (iM3548I == -5) {
                    Format2 format2 = formatHolderM3547A.f7196b;
                    Objects.requireNonNull(format2);
                    this.f9139B = format2.f7127A;
                }
            }
            Metadata metadata = this.f9141D;
            if (metadata == null || this.f9140C > j) {
                z2 = false;
            } else {
                Handler handler = this.f9144w;
                if (handler != null) {
                    handler.obtainMessage(0, metadata).sendToTarget();
                } else {
                    this.f9143v.mo3298b(metadata);
                }
                this.f9141D = null;
                this.f9140C = -9223372036854775807L;
                z2 = true;
            }
            if (this.f9147z && this.f9141D == null) {
                this.f9138A = true;
            }
        }
    }
}
