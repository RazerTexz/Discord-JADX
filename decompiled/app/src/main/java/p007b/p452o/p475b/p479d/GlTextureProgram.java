package p007b.p452o.p475b.p479d;

import android.graphics.RectF;
import com.discord.models.domain.ModelAuditLogEntry;
import java.nio.FloatBuffer;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p475b.p476a.Egloo;
import p007b.p452o.p475b.p477b.Gl2dDrawable;
import p007b.p452o.p475b.p479d.GlProgramLocation;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.o.b.d.d, reason: use source file name */
/* JADX INFO: compiled from: GlTextureProgram.kt */
/* JADX INFO: loaded from: classes3.dex */
public class GlTextureProgram extends GlProgram {

    /* JADX INFO: renamed from: e */
    public float[] f14318e;

    /* JADX INFO: renamed from: f */
    public final GlProgramLocation f14319f;

    /* JADX INFO: renamed from: g */
    public FloatBuffer f14320g;

    /* JADX INFO: renamed from: h */
    public final GlProgramLocation f14321h;

    /* JADX INFO: renamed from: i */
    public final GlProgramLocation f14322i;

    /* JADX INFO: renamed from: j */
    public final GlProgramLocation f14323j;

    /* JADX INFO: renamed from: k */
    public final RectF f14324k;

    /* JADX INFO: renamed from: l */
    public int f14325l;

    /* JADX INFO: renamed from: m */
    public Gl2dDrawable f14326m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlTextureProgram(int i, String str, String str2, String str3, String str4) {
        super(i, false, new GlShader2[0]);
        Intrinsics3.checkNotNullParameter(str, "vertexPositionName");
        Intrinsics3.checkNotNullParameter(str2, "vertexMvpMatrixName");
        GlProgramLocation.a aVar = GlProgramLocation.a.ATTRIB;
        GlProgramLocation.a aVar2 = GlProgramLocation.a.UNIFORM;
        Intrinsics3.checkNotNullParameter(str, "vertexPositionName");
        Intrinsics3.checkNotNullParameter(str2, "vertexMvpMatrixName");
        this.f14318e = C3404f.m4217J0(Egloo.f14263a);
        Intrinsics3.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i2 = this.f14306a;
        Intrinsics3.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f14319f = new GlProgramLocation(i2, aVar2, str4, null);
        this.f14320g = C3404f.m4258X(8);
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i3 = this.f14306a;
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f14321h = new GlProgramLocation(i3, aVar, str3, null);
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i4 = this.f14306a;
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f14322i = new GlProgramLocation(i4, aVar, str, null);
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i5 = this.f14306a;
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f14323j = new GlProgramLocation(i5, aVar2, str2, null);
        this.f14324k = new RectF();
        this.f14325l = -1;
    }
}
