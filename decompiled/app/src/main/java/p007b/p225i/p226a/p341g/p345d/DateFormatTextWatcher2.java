package p007b.p225i.p226a.p341g.p345d;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.g.d.d, reason: use source file name */
/* JADX INFO: compiled from: DateFormatTextWatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class DateFormatTextWatcher2 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ long f11600j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ DateFormatTextWatcher f11601k;

    public DateFormatTextWatcher2(DateFormatTextWatcher dateFormatTextWatcher, long j) {
        this.f11601k = dateFormatTextWatcher;
        this.f11600j = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        DateFormatTextWatcher dateFormatTextWatcher = this.f11601k;
        dateFormatTextWatcher.f11592j.setError(String.format(dateFormatTextWatcher.f11595m, C3404f.m4292g0(this.f11600j)));
        this.f11601k.mo6060a();
    }
}
