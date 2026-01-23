package com.franmontiel.persistentcookiejar;

import com.franmontiel.persistentcookiejar.cache.CookieCache;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.CookiePersistor;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p600f0.Cookie;
import p600f0.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
public class PersistentCookieJar implements ClearableCookieJar {

    /* JADX INFO: renamed from: b */
    public CookieCache f19665b;

    /* JADX INFO: renamed from: c */
    public CookiePersistor f19666c;

    public PersistentCookieJar(CookieCache cookieCache, CookiePersistor cookiePersistor) {
        this.f19665b = cookieCache;
        this.f19666c = cookiePersistor;
        ((SetCookieCache) cookieCache).addAll(((SharedPrefsCookiePersistor) cookiePersistor).m8749c());
    }

    @Override // p600f0.CookieJar2
    /* JADX INFO: renamed from: a */
    public synchronized void mo8745a(HttpUrl httpUrl, List<Cookie> list) {
        this.f19665b.addAll(list);
        CookiePersistor cookiePersistor = this.f19666c;
        ArrayList arrayList = new ArrayList();
        for (Cookie cookie : list) {
            if (cookie.f25954m) {
                arrayList.add(cookie);
            }
        }
        cookiePersistor.mo8747a(arrayList);
    }

    @Override // p600f0.CookieJar2
    /* JADX INFO: renamed from: b */
    public synchronized List<Cookie> mo8746b(HttpUrl httpUrl) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        Iterator<Cookie> it = this.f19665b.iterator();
        while (it.hasNext()) {
            Cookie next = it.next();
            if (next.f25949h < System.currentTimeMillis()) {
                arrayList2.add(next);
                it.remove();
            } else if (next.m10384a(httpUrl)) {
                arrayList.add(next);
            }
        }
        this.f19666c.removeAll(arrayList2);
        return arrayList;
    }
}
