package p007b.p437j.p438a;

import com.hcaptcha.sdk.HCaptchaTokenResponse;

/* renamed from: b.j.a.d */
/* loaded from: classes3.dex */
public class RunnableC5068d implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ HCaptchaTokenResponse f13592j;

    /* renamed from: k */
    public final /* synthetic */ C5067c f13593k;

    public RunnableC5068d(C5067c c5067c, HCaptchaTokenResponse hCaptchaTokenResponse) {
        this.f13593k = c5067c;
        this.f13592j = hCaptchaTokenResponse;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13593k.f13586n.mo9264b(this.f13592j);
    }
}
