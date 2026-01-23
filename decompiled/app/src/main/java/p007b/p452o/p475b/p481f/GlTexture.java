package p007b.p452o.p475b.p481f;

import android.opengl.GLES20;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p452o.p475b.p476a.Egloo;
import p007b.p452o.p475b.p478c.gl;
import p507d0.UInt;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.o.b.f.a, reason: use source file name */
/* JADX INFO: compiled from: GlTexture.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GlTexture extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Integer $internalFormat;
    public final /* synthetic */ GlTexture2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlTexture(GlTexture2 glTexture2, Integer num) {
        super(0);
        this.this$0 = glTexture2;
        this.$internalFormat = num;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        GlTexture2 glTexture2 = this.this$0;
        if (glTexture2.f14333c != null && glTexture2.f14334d != null && glTexture2.f14335e != null && this.$internalFormat != null && glTexture2.f14336f != null) {
            GLES20.glTexImage2D(UInt.m11482constructorimpl(glTexture2.f14332b), 0, this.$internalFormat.intValue(), this.this$0.f14333c.intValue(), this.this$0.f14334d.intValue(), 0, UInt.m11482constructorimpl(this.this$0.f14335e.intValue()), UInt.m11482constructorimpl(this.this$0.f14336f.intValue()), null);
        }
        GLES20.glTexParameterf(UInt.m11482constructorimpl(this.this$0.f14332b), gl.f14295e, gl.f14300j);
        GLES20.glTexParameterf(UInt.m11482constructorimpl(this.this$0.f14332b), gl.f14296f, gl.f14301k);
        int iM11482constructorimpl = UInt.m11482constructorimpl(this.this$0.f14332b);
        int i = gl.f14297g;
        int i2 = gl.f14299i;
        GLES20.glTexParameteri(iM11482constructorimpl, i, i2);
        GLES20.glTexParameteri(UInt.m11482constructorimpl(this.this$0.f14332b), gl.f14298h, i2);
        Egloo.m7457b("glTexParameter");
        return Unit.f27425a;
    }
}
