package com.franmontiel.persistentcookiejar.cache;

import java.util.Collection;
import p600f0.Cookie;

/* JADX INFO: loaded from: classes3.dex */
public interface CookieCache extends Iterable<Cookie> {
    void addAll(Collection<Cookie> collection);
}
