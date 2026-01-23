package com.franmontiel.persistentcookiejar.cache;

import p007b.p100d.p104b.p105a.outline;
import p600f0.Cookie;

/* JADX INFO: loaded from: classes3.dex */
public class IdentifiableCookie {

    /* JADX INFO: renamed from: a */
    public Cookie f19667a;

    public IdentifiableCookie(Cookie cookie) {
        this.f19667a = cookie;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IdentifiableCookie)) {
            return false;
        }
        IdentifiableCookie identifiableCookie = (IdentifiableCookie) obj;
        if (!identifiableCookie.f19667a.f25947f.equals(this.f19667a.f25947f) || !identifiableCookie.f19667a.f25950i.equals(this.f19667a.f25950i) || !identifiableCookie.f19667a.f25951j.equals(this.f19667a.f25951j)) {
            return false;
        }
        Cookie cookie = identifiableCookie.f19667a;
        boolean z2 = cookie.f25952k;
        Cookie cookie2 = this.f19667a;
        return z2 == cookie2.f25952k && cookie.f25955n == cookie2.f25955n;
    }

    public int hashCode() {
        int iM863m = outline.m863m(this.f19667a.f25951j, outline.m863m(this.f19667a.f25950i, outline.m863m(this.f19667a.f25947f, 527, 31), 31), 31);
        Cookie cookie = this.f19667a;
        return ((iM863m + (!cookie.f25952k ? 1 : 0)) * 31) + (!cookie.f25955n ? 1 : 0);
    }
}
