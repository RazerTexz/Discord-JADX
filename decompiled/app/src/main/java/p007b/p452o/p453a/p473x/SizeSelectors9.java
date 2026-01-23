package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.o.a.x.l, reason: use source file name */
/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class SizeSelectors9 implements SizeSelector {

    /* JADX INFO: renamed from: a */
    public SizeSelector[] f14259a;

    public SizeSelectors9(SizeSelector[] sizeSelectorArr, C3404f.a aVar) {
        this.f14259a = sizeSelectorArr;
    }

    @Override // p007b.p452o.p453a.p473x.SizeSelector
    @NonNull
    /* JADX INFO: renamed from: a */
    public List<Size3> mo7452a(@NonNull List<Size3> list) {
        List<Size3> listMo7452a = null;
        for (SizeSelector sizeSelector : this.f14259a) {
            listMo7452a = sizeSelector.mo7452a(list);
            if (!listMo7452a.isEmpty()) {
                break;
            }
        }
        return listMo7452a == null ? new ArrayList() : listMo7452a;
    }
}
