package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.k, reason: use source file name */
/* JADX INFO: compiled from: LazyStringArrayList.java */
/* JADX INFO: loaded from: classes3.dex */
public class LazyStringArrayList extends AbstractList<String> implements RandomAccess, LazyStringList {

    /* JADX INFO: renamed from: j */
    public static final LazyStringList f24147j = new LazyStringArrayList().getUnmodifiableView();

    /* JADX INFO: renamed from: k */
    public final List<Object> f24148k;

    public LazyStringArrayList() {
        this.f24148k = new ArrayList();
    }

    /* JADX INFO: renamed from: c */
    public static String m9856c(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof ByteString3 ? ((ByteString3) obj).toStringUtf8() : Internal.toStringUtf8((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        add(i, (String) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f24148k.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return get(i);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.LazyStringList
    public ByteString3 getByteString(int i) {
        Object obj = this.f24148k.get(i);
        ByteString3 byteString3CopyFromUtf8 = obj instanceof ByteString3 ? (ByteString3) obj : obj instanceof String ? ByteString3.copyFromUtf8((String) obj) : ByteString3.copyFrom((byte[]) obj);
        if (byteString3CopyFromUtf8 != obj) {
            this.f24148k.set(i, byteString3CopyFromUtf8);
        }
        return byteString3CopyFromUtf8;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f24148k);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return new UnmodifiableLazyStringList(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i) {
        return remove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        return set(i, (String) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f24148k.size();
    }

    public void add(int i, String str) {
        this.f24148k.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f24148k.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        Object obj = this.f24148k.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString3) {
            ByteString3 byteString3 = (ByteString3) obj;
            String stringUtf8 = byteString3.toStringUtf8();
            if (byteString3.isValidUtf8()) {
                this.f24148k.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.f24148k.set(i, stringUtf82);
        }
        return stringUtf82;
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int i) {
        Object objRemove = this.f24148k.remove(i);
        ((AbstractList) this).modCount++;
        return m9856c(objRemove);
    }

    public String set(int i, String str) {
        return m9856c(this.f24148k.set(i, str));
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.f24148k = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.LazyStringList
    public void add(ByteString3 byteString3) {
        this.f24148k.add(byteString3);
        ((AbstractList) this).modCount++;
    }
}
