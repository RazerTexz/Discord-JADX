package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.o.a.x.i, reason: use source file name */
/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class SizeSelectors6 implements SizeSelector {

    /* JADX INFO: renamed from: a */
    public SizeSelector[] f14257a;

    public SizeSelectors6(SizeSelector[] sizeSelectorArr, C3404f.a aVar) {
        this.f14257a = sizeSelectorArr;
    }

    @Override // p007b.p452o.p453a.p473x.SizeSelector
    @NonNull
    /* JADX INFO: renamed from: a */
    public List<Size3> mo7452a(@NonNull List<Size3> list) {
        for (SizeSelector sizeSelector : this.f14257a) {
            list = sizeSelector.mo7452a(list);
        }
        return list;
    }
}
