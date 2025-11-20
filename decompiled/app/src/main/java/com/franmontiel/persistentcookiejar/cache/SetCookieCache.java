package com.franmontiel.persistentcookiejar.cache;

import f0.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class SetCookieCache implements CookieCache {
    public Set<IdentifiableCookie> j = new HashSet();

    public class SetCookieCacheIterator implements Iterator<n> {
        public Iterator<IdentifiableCookie> j;

        public SetCookieCacheIterator(SetCookieCache setCookieCache) {
            this.j = setCookieCache.j.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.hasNext();
        }

        @Override // java.util.Iterator
        public n next() {
            return this.j.next().a;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.j.remove();
        }
    }

    @Override // com.franmontiel.persistentcookiejar.cache.CookieCache
    public void addAll(Collection<n> collection) {
        ArrayList<IdentifiableCookie> arrayList = new ArrayList(collection.size());
        Iterator<n> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new IdentifiableCookie(it.next()));
        }
        for (IdentifiableCookie identifiableCookie : arrayList) {
            this.j.remove(identifiableCookie);
            this.j.add(identifiableCookie);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<n> iterator() {
        return new SetCookieCacheIterator(this);
    }
}
