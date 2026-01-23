package p007b.p452o.p453a.p455n;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.CameraOptions;
import p007b.p452o.p453a.CameraView5;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p454m.Audio;
import p007b.p452o.p453a.p454m.AudioCodec;
import p007b.p452o.p453a.p454m.Facing;
import p007b.p452o.p453a.p454m.Flash;
import p007b.p452o.p453a.p454m.Hdr;
import p007b.p452o.p453a.p454m.Mode3;
import p007b.p452o.p453a.p454m.PictureFormat;
import p007b.p452o.p453a.p454m.VideoCodec;
import p007b.p452o.p453a.p454m.WhiteBalance;
import p007b.p452o.p453a.p455n.CameraEngine;
import p007b.p452o.p453a.p455n.p461t.Angles;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p455n.p463v.CameraState2;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator;
import p007b.p452o.p453a.p455n.p463v.CameraStateOrchestrator3;
import p007b.p452o.p453a.p465p.FrameManager;
import p007b.p452o.p453a.p470u.Overlay;
import p007b.p452o.p453a.p471v.PictureRecorder;
import p007b.p452o.p453a.p472w.CameraPreview;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p453a.p473x.Size3;
import p007b.p452o.p453a.p473x.SizeSelector;
import p007b.p452o.p453a.p473x.SizeSelectors;
import p007b.p452o.p453a.p473x.SizeSelectors2;
import p007b.p452o.p453a.p473x.SizeSelectors3;
import p007b.p452o.p453a.p473x.SizeSelectors9;

/* JADX INFO: renamed from: b.o.a.n.g, reason: use source file name */
/* JADX INFO: compiled from: CameraBaseEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraBaseEngine extends CameraEngine {

    /* JADX INFO: renamed from: A */
    public Hdr f13866A;

    /* JADX INFO: renamed from: B */
    public PictureFormat f13867B;

    /* JADX INFO: renamed from: C */
    public Location f13868C;

    /* JADX INFO: renamed from: D */
    public float f13869D;

    /* JADX INFO: renamed from: E */
    public float f13870E;

    /* JADX INFO: renamed from: F */
    public boolean f13871F;

    /* JADX INFO: renamed from: G */
    public boolean f13872G;

    /* JADX INFO: renamed from: H */
    public boolean f13873H;

    /* JADX INFO: renamed from: I */
    public float f13874I;

    /* JADX INFO: renamed from: J */
    public boolean f13875J;

    /* JADX INFO: renamed from: K */
    public FrameManager f13876K;

    /* JADX INFO: renamed from: L */
    public final Angles f13877L;

    /* JADX INFO: renamed from: M */
    @Nullable
    public SizeSelector f13878M;

    /* JADX INFO: renamed from: N */
    public SizeSelector f13879N;

    /* JADX INFO: renamed from: O */
    public SizeSelector f13880O;

    /* JADX INFO: renamed from: P */
    public Facing f13881P;

    /* JADX INFO: renamed from: Q */
    public Mode3 f13882Q;

    /* JADX INFO: renamed from: R */
    public Audio f13883R;

    /* JADX INFO: renamed from: S */
    public long f13884S;

    /* JADX INFO: renamed from: T */
    public int f13885T;

    /* JADX INFO: renamed from: U */
    public int f13886U;

    /* JADX INFO: renamed from: V */
    public int f13887V;

    /* JADX INFO: renamed from: W */
    public long f13888W;

    /* JADX INFO: renamed from: X */
    public int f13889X;

    /* JADX INFO: renamed from: Y */
    public int f13890Y;

    /* JADX INFO: renamed from: Z */
    public int f13891Z;

    /* JADX INFO: renamed from: a0 */
    public int f13892a0;

    /* JADX INFO: renamed from: b0 */
    public int f13893b0;

    /* JADX INFO: renamed from: c0 */
    public Overlay f13894c0;

    /* JADX INFO: renamed from: o */
    public CameraPreview f13895o;

    /* JADX INFO: renamed from: p */
    public CameraOptions f13896p;

    /* JADX INFO: renamed from: q */
    public PictureRecorder f13897q;

    /* JADX INFO: renamed from: r */
    public Size3 f13898r;

    /* JADX INFO: renamed from: s */
    public Size3 f13899s;

    /* JADX INFO: renamed from: t */
    public Size3 f13900t;

    /* JADX INFO: renamed from: u */
    public int f13901u;

    /* JADX INFO: renamed from: v */
    public boolean f13902v;

    /* JADX INFO: renamed from: w */
    public Flash f13903w;

    /* JADX INFO: renamed from: x */
    public WhiteBalance f13904x;

    /* JADX INFO: renamed from: y */
    public VideoCodec f13905y;

    /* JADX INFO: renamed from: z */
    public AudioCodec f13906z;

    /* JADX INFO: renamed from: b.o.a.n.g$a */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Facing f13907j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Facing f13908k;

        public a(Facing facing, Facing facing2) {
            this.f13907j = facing;
            this.f13908k = facing2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraBaseEngine.this.mo7205c(this.f13907j)) {
                CameraBaseEngine.this.m7327X();
            } else {
                CameraBaseEngine.this.f13881P = this.f13908k;
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.g$b */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraBaseEngine.this.m7327X();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.g$c */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class c implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ PictureResult.a f13911j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f13912k;

        public c(PictureResult.a aVar, boolean z2) {
            this.f13911j = aVar;
            this.f13912k = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEngine.f13918j.m7159a(1, "takePicture:", "running. isTakingPicture:", Boolean.valueOf(CameraBaseEngine.this.m7275W0()));
            if (CameraBaseEngine.this.m7275W0()) {
                return;
            }
            CameraBaseEngine cameraBaseEngine = CameraBaseEngine.this;
            if (cameraBaseEngine.f13882Q == Mode3.VIDEO) {
                throw new IllegalStateException("Can't take hq pictures while in VIDEO mode");
            }
            PictureResult.a aVar = this.f13911j;
            aVar.f13715a = false;
            aVar.f13716b = cameraBaseEngine.f13868C;
            aVar.f13719e = cameraBaseEngine.f13881P;
            aVar.f13721g = cameraBaseEngine.f13867B;
            cameraBaseEngine.mo7202Y0(aVar, this.f13912k);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.g$d */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ PictureResult.a f13914j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f13915k;

        public d(PictureResult.a aVar, boolean z2) {
            this.f13914j = aVar;
            this.f13915k = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEngine.f13918j.m7159a(1, "takePictureSnapshot:", "running. isTakingPicture:", Boolean.valueOf(CameraBaseEngine.this.m7275W0()));
            if (CameraBaseEngine.this.m7275W0()) {
                return;
            }
            PictureResult.a aVar = this.f13914j;
            CameraBaseEngine cameraBaseEngine = CameraBaseEngine.this;
            aVar.f13716b = cameraBaseEngine.f13868C;
            aVar.f13715a = true;
            aVar.f13719e = cameraBaseEngine.f13881P;
            aVar.f13721g = PictureFormat.JPEG;
            CameraBaseEngine.this.mo7203Z0(this.f13914j, AspectRatio2.m7448g(cameraBaseEngine.m7274U0(Reference2.OUTPUT)), this.f13915k);
        }
    }

    public CameraBaseEngine(@NonNull CameraEngine.g gVar) {
        super(gVar);
        this.f13877L = new Angles();
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: A */
    public final float mo7250A() {
        return this.f13874I;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: A0 */
    public final void mo7251A0(int i) {
        this.f13886U = i;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: B */
    public final boolean mo7252B() {
        return this.f13875J;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: B0 */
    public final void mo7253B0(@NonNull VideoCodec videoCodec) {
        this.f13905y = videoCodec;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @Nullable
    /* JADX INFO: renamed from: C */
    public final Size3 mo7254C(@NonNull Reference2 reference2) {
        Size3 size3 = this.f13899s;
        if (size3 == null) {
            return null;
        }
        return this.f13877L.m7357b(Reference2.SENSOR, reference2) ? size3.m7451f() : size3;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: C0 */
    public final void mo7255C0(int i) {
        this.f13885T = i;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: D */
    public final int mo7256D() {
        return this.f13890Y;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: D0 */
    public final void mo7257D0(long j) {
        this.f13884S = j;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: E */
    public final int mo7258E() {
        return this.f13889X;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: E0 */
    public final void mo7259E0(@NonNull SizeSelector sizeSelector) {
        this.f13880O = sizeSelector;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @Nullable
    /* JADX INFO: renamed from: F */
    public final Size3 mo7260F(@NonNull Reference2 reference2) {
        Size3 size3Mo7254C = mo7254C(reference2);
        if (size3Mo7254C == null) {
            return null;
        }
        boolean zM7357b = this.f13877L.m7357b(reference2, Reference2.VIEW);
        int i = zM7357b ? this.f13890Y : this.f13889X;
        int i2 = zM7357b ? this.f13889X : this.f13890Y;
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        if (i2 <= 0) {
            i2 = Integer.MAX_VALUE;
        }
        HashMap<String, AspectRatio2> map = AspectRatio2.f14248j;
        if (AspectRatio2.m7447f(i, i2).m7450i() >= AspectRatio2.m7447f(size3Mo7254C.f14251j, size3Mo7254C.f14252k).m7450i()) {
            return new Size3((int) Math.floor(r5 * r2), Math.min(size3Mo7254C.f14252k, i2));
        }
        return new Size3(Math.min(size3Mo7254C.f14251j, i), (int) Math.floor(r5 / r2));
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: G */
    public final int mo7261G() {
        return this.f13886U;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: H */
    public final VideoCodec mo7262H() {
        return this.f13905y;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: I */
    public final int mo7263I() {
        return this.f13885T;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: J */
    public final long mo7264J() {
        return this.f13884S;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @Nullable
    /* JADX INFO: renamed from: K */
    public final Size3 mo7265K(@NonNull Reference2 reference2) {
        Size3 size3 = this.f13898r;
        if (size3 == null || this.f13882Q == Mode3.PICTURE) {
            return null;
        }
        return this.f13877L.m7357b(Reference2.SENSOR, reference2) ? size3.m7451f() : size3;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: L */
    public final SizeSelector mo7266L() {
        return this.f13880O;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: M */
    public final WhiteBalance mo7267M() {
        return this.f13904x;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: N */
    public final float mo7268N() {
        return this.f13869D;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: O0 */
    public void mo7269O0(@NonNull PictureResult.a aVar) {
        boolean z2 = this.f13872G;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("take picture", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.BIND, new c(aVar, z2)));
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: P0 */
    public void mo7270P0(@NonNull PictureResult.a aVar) {
        boolean z2 = this.f13873H;
        CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
        cameraStateOrchestrator.m7363b("take picture snapshot", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.BIND, new d(aVar, z2)));
    }

    @NonNull
    /* JADX INFO: renamed from: Q0 */
    public final Size3 m7271Q0(@NonNull Mode3 mode3) {
        SizeSelector sizeSelector;
        Set setUnmodifiableSet;
        boolean zM7357b = this.f13877L.m7357b(Reference2.SENSOR, Reference2.VIEW);
        if (mode3 == Mode3.PICTURE) {
            sizeSelector = this.f13879N;
            setUnmodifiableSet = Collections.unmodifiableSet(this.f13896p.f13686e);
        } else {
            sizeSelector = this.f13880O;
            setUnmodifiableSet = Collections.unmodifiableSet(this.f13896p.f13687f);
        }
        SizeSelector sizeSelectorM4238Q0 = C3404f.m4238Q0(sizeSelector, new SizeSelectors2());
        ArrayList arrayList = new ArrayList(setUnmodifiableSet);
        Size3 size3 = ((SizeSelectors9) sizeSelectorM4238Q0).mo7452a(arrayList).get(0);
        if (!arrayList.contains(size3)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        CameraEngine.f13918j.m7159a(1, "computeCaptureSize:", "result:", size3, "flip:", Boolean.valueOf(zM7357b), "mode:", mode3);
        return zM7357b ? size3.m7451f() : size3;
    }

    @NonNull
    /* JADX INFO: renamed from: R0 */
    public final Size3 m7272R0() {
        Reference2 reference2 = Reference2.VIEW;
        List<Size3> listMo7198T0 = mo7198T0();
        boolean zM7357b = this.f13877L.m7357b(Reference2.SENSOR, reference2);
        ArrayList arrayList = new ArrayList(listMo7198T0.size());
        for (Size3 size3M7451f : listMo7198T0) {
            if (zM7357b) {
                size3M7451f = size3M7451f.m7451f();
            }
            arrayList.add(size3M7451f);
        }
        Size3 size3M7274U0 = m7274U0(reference2);
        if (size3M7274U0 == null) {
            throw new IllegalStateException("targetMinSize should not be null here.");
        }
        Size3 size3 = this.f13898r;
        AspectRatio2 aspectRatio2M7447f = AspectRatio2.m7447f(size3.f14251j, size3.f14252k);
        if (zM7357b) {
            aspectRatio2M7447f = AspectRatio2.m7447f(aspectRatio2M7447f.f14250l, aspectRatio2M7447f.f14249k);
        }
        CameraLogger cameraLogger = CameraEngine.f13918j;
        cameraLogger.m7159a(1, "computePreviewStreamSize:", "targetRatio:", aspectRatio2M7447f, "targetMinSize:", size3M7274U0);
        SizeSelector sizeSelectorM4291g = C3404f.m4291g(C3404f.m4200D1(new SizeSelectors(aspectRatio2M7447f.m7450i(), 0.0f)), new SizeSelectors2());
        SizeSelector sizeSelectorM4291g2 = C3404f.m4291g(C3404f.m4226M0(size3M7274U0.f14252k), C3404f.m4229N0(size3M7274U0.f14251j), new SizeSelectors3());
        SizeSelector sizeSelectorM4238Q0 = C3404f.m4238Q0(C3404f.m4291g(sizeSelectorM4291g, sizeSelectorM4291g2), sizeSelectorM4291g2, sizeSelectorM4291g, new SizeSelectors2());
        SizeSelector sizeSelector = this.f13878M;
        if (sizeSelector != null) {
            sizeSelectorM4238Q0 = C3404f.m4238Q0(sizeSelector, sizeSelectorM4238Q0);
        }
        Size3 size3M7451f2 = ((SizeSelectors9) sizeSelectorM4238Q0).mo7452a(arrayList).get(0);
        if (!arrayList.contains(size3M7451f2)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        if (zM7357b) {
            size3M7451f2 = size3M7451f2.m7451f();
        }
        cameraLogger.m7159a(1, "computePreviewStreamSize:", "result:", size3M7451f2, "flip:", Boolean.valueOf(zM7357b));
        return size3M7451f2;
    }

    @NonNull
    /* JADX INFO: renamed from: S0 */
    public FrameManager m7273S0() {
        if (this.f13876K == null) {
            this.f13876K = mo7200V0(this.f13893b0);
        }
        return this.f13876K;
    }

    @NonNull
    /* JADX INFO: renamed from: T0 */
    public abstract List<Size3> mo7198T0();

    @Nullable
    /* JADX INFO: renamed from: U0 */
    public final Size3 m7274U0(@NonNull Reference2 reference2) {
        CameraPreview cameraPreview = this.f13895o;
        if (cameraPreview == null) {
            return null;
        }
        return this.f13877L.m7357b(Reference2.VIEW, reference2) ? cameraPreview.m7432l().m7451f() : cameraPreview.m7432l();
    }

    @NonNull
    /* JADX INFO: renamed from: V0 */
    public abstract FrameManager mo7200V0(int i);

    /* JADX INFO: renamed from: W0 */
    public final boolean m7275W0() {
        return this.f13897q != null;
    }

    /* JADX INFO: renamed from: X0 */
    public abstract void mo7201X0();

    /* JADX INFO: renamed from: Y0 */
    public abstract void mo7202Y0(@NonNull PictureResult.a aVar, boolean z2);

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: Z */
    public final void mo7276Z(@NonNull Audio audio) {
        if (this.f13883R != audio) {
            this.f13883R = audio;
        }
    }

    /* JADX INFO: renamed from: Z0 */
    public abstract void mo7203Z0(@NonNull PictureResult.a aVar, @NonNull AspectRatio2 aspectRatio2, boolean z2);

    /* JADX INFO: renamed from: a */
    public void mo7227a(@Nullable PictureResult.a aVar, @Nullable Exception exc) {
        this.f13897q = null;
        if (aVar == null) {
            CameraEngine.f13918j.m7159a(3, "onPictureResult", "result is null: something went wrong.", exc);
            ((CameraView.C11195b) this.f13921m).m9311a(new CameraException(exc, 4));
        } else {
            CameraView.C11195b c11195b = (CameraView.C11195b) this.f13921m;
            c11195b.f22141b.m7159a(1, "dispatchOnPictureTaken", aVar);
            CameraView.this.f22133u.post(new CameraView5(c11195b, aVar));
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: a0 */
    public final void mo7277a0(int i) {
        this.f13887V = i;
    }

    /* JADX INFO: renamed from: a1 */
    public final boolean m7278a1() {
        long j = this.f13888W;
        return j > 0 && j != RecyclerView.FOREVER_NS;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: b0 */
    public final void mo7279b0(@NonNull AudioCodec audioCodec) {
        this.f13906z = audioCodec;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: c0 */
    public final void mo7280c0(long j) {
        this.f13888W = j;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: e */
    public final Angles mo7281e() {
        return this.f13877L;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: e0 */
    public final void mo7282e0(@NonNull Facing facing) {
        Facing facing2 = this.f13881P;
        if (facing != facing2) {
            this.f13881P = facing;
            CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
            cameraStateOrchestrator.m7363b("facing", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new a(facing, facing2)));
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: f */
    public final Audio mo7283f() {
        return this.f13883R;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: g */
    public final int mo7284g() {
        return this.f13887V;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: h */
    public final AudioCodec mo7285h() {
        return this.f13906z;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: h0 */
    public final void mo7286h0(int i) {
        this.f13892a0 = i;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: i */
    public final long mo7287i() {
        return this.f13888W;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: i0 */
    public final void mo7288i0(int i) {
        this.f13891Z = i;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @Nullable
    /* JADX INFO: renamed from: j */
    public final CameraOptions mo7289j() {
        return this.f13896p;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: j0 */
    public final void mo7290j0(int i) {
        this.f13893b0 = i;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: k */
    public final float mo7291k() {
        return this.f13870E;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: l */
    public final Facing mo7292l() {
        return this.f13881P;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: m */
    public final Flash mo7293m() {
        return this.f13903w;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: n */
    public final int mo7294n() {
        return this.f13901u;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: n0 */
    public final void mo7295n0(@NonNull Mode3 mode3) {
        if (mode3 != this.f13882Q) {
            this.f13882Q = mode3;
            CameraStateOrchestrator cameraStateOrchestrator = this.f13922n;
            cameraStateOrchestrator.m7363b("mode", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new b()));
        }
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: o */
    public final int mo7296o() {
        return this.f13892a0;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: o0 */
    public final void mo7297o0(@Nullable Overlay overlay) {
        this.f13894c0 = overlay;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: p */
    public final int mo7298p() {
        return this.f13891Z;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: q */
    public final int mo7299q() {
        return this.f13893b0;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: q0 */
    public final void mo7300q0(boolean z2) {
        this.f13872G = z2;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: r */
    public final Hdr mo7301r() {
        return this.f13866A;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: r0 */
    public final void mo7302r0(@NonNull SizeSelector sizeSelector) {
        this.f13879N = sizeSelector;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @Nullable
    /* JADX INFO: renamed from: s */
    public final Location mo7303s() {
        return this.f13868C;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: s0 */
    public final void mo7304s0(boolean z2) {
        this.f13873H = z2;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: t */
    public final Mode3 mo7305t() {
        return this.f13882Q;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: u */
    public final PictureFormat mo7306u() {
        return this.f13867B;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: u0 */
    public final void mo7307u0(@NonNull CameraPreview cameraPreview) {
        CameraPreview cameraPreview2 = this.f13895o;
        if (cameraPreview2 != null) {
            cameraPreview2.m7440t(null);
        }
        this.f13895o = cameraPreview;
        cameraPreview.m7440t(this);
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: v */
    public final boolean mo7308v() {
        return this.f13872G;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @Nullable
    /* JADX INFO: renamed from: w */
    public final Size3 mo7309w(@NonNull Reference2 reference2) {
        Size3 size3 = this.f13898r;
        if (size3 == null || this.f13882Q == Mode3.VIDEO) {
            return null;
        }
        return this.f13877L.m7357b(Reference2.SENSOR, reference2) ? size3.m7451f() : size3;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: w0 */
    public final void mo7310w0(boolean z2) {
        this.f13875J = z2;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: x */
    public final SizeSelector mo7311x() {
        return this.f13879N;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: x0 */
    public final void mo7312x0(@Nullable SizeSelector sizeSelector) {
        this.f13878M = sizeSelector;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: y */
    public final boolean mo7313y() {
        return this.f13873H;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: y0 */
    public final void mo7314y0(int i) {
        this.f13890Y = i;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    @NonNull
    /* JADX INFO: renamed from: z */
    public final CameraPreview mo7315z() {
        return this.f13895o;
    }

    @Override // p007b.p452o.p453a.p455n.CameraEngine
    /* JADX INFO: renamed from: z0 */
    public final void mo7316z0(int i) {
        this.f13889X = i;
    }
}
