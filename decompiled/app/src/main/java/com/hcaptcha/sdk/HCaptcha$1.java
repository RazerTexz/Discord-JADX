package com.hcaptcha.sdk;

import p007b.p437j.p438a.C5065a;

/* loaded from: classes3.dex */
public class HCaptcha$1 extends HCaptchaDialogListener {

    /* renamed from: j */
    public final /* synthetic */ C5065a f21673j;

    public HCaptcha$1(C5065a c5065a) {
        this.f21673j = c5065a;
    }

    @Override // com.hcaptcha.sdk.HCaptchaDialogListener
    /* renamed from: a */
    public void mo9263a(HCaptchaException hCaptchaException) {
        C5065a c5065a = this.f21673j;
        c5065a.f13595b = hCaptchaException;
        c5065a.m7120a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hcaptcha.sdk.HCaptchaDialogListener
    /* renamed from: b */
    public void mo9264b(HCaptchaTokenResponse hCaptchaTokenResponse) {
        C5065a c5065a = this.f21673j;
        c5065a.f13594a = hCaptchaTokenResponse;
        c5065a.m7120a();
    }
}
