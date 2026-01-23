package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.o.a.x.k, reason: use source file name */
/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class SizeSelectors8 implements SizeSelector {

    /* JADX INFO: renamed from: a */
    public SizeSelectors7 f14258a;

    public SizeSelectors8(SizeSelectors7 sizeSelectors7, C3404f.a aVar) {
        this.f14258a = sizeSelectors7;
    }

    @Override // p007b.p452o.p453a.p473x.SizeSelector
    @NonNull
    /* JADX INFO: renamed from: a */
    public List<Size3> mo7452a(@NonNull List<Size3> list) {
        ArrayList arrayList = new ArrayList();
        for (Size3 size3 : list) {
            if (this.f14258a.mo4369a(size3)) {
                arrayList.add(size3);
            }
        }
        return arrayList;
    }
}
