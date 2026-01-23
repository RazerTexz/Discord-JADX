package p007b.p225i.p226a.p242c.p267x2.p276k0;

import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.TimestampAdjuster;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.z, reason: use source file name */
/* JADX INFO: compiled from: PsBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PsBinarySearchSeeker extends BinarySearchSeeker {

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.z$b */
    /* JADX INFO: compiled from: PsBinarySearchSeeker.java */
    public static final class b implements BinarySearchSeeker.f {

        /* JADX INFO: renamed from: a */
        public final TimestampAdjuster f8923a;

        /* JADX INFO: renamed from: b */
        public final ParsableByteArray f8924b = new ParsableByteArray();

        public b(TimestampAdjuster timestampAdjuster, a aVar) {
            this.f8923a = timestampAdjuster;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker.f
        /* JADX INFO: renamed from: a */
        public void mo3627a() {
            this.f8924b.m3076B(Util2.f6713f);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:36:0x00d5
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
            */
        @Override // p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker.f
        /* JADX INFO: renamed from: b */
        public p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker.e mo3628b(p007b.p225i.p226a.p242c.p267x2.ExtractorInput r17, long r18) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 284
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p007b.p225i.p226a.p242c.p267x2.p276k0.PsBinarySearchSeeker.b.mo3628b(b.i.a.c.x2.i, long):b.i.a.c.x2.a$e");
        }
    }

    public PsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j, long j2) {
        super(new BinarySearchSeeker.b(), new b(timestampAdjuster, null), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    /* JADX INFO: renamed from: g */
    public static int m3794g(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
