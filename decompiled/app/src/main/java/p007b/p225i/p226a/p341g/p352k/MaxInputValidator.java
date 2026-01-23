package p007b.p225i.p226a.p341g.p352k;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: renamed from: b.i.a.g.k.d, reason: use source file name */
/* JADX INFO: compiled from: MaxInputValidator.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxInputValidator implements InputFilter {

    /* JADX INFO: renamed from: a */
    public int f11860a;

    public MaxInputValidator(int i) {
        this.f11860a = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i3, i4, charSequence.subSequence(i, i2).toString());
            if (Integer.parseInt(sb.toString()) <= this.f11860a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
