package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: MutablePartitionedIterator.kt */
/* loaded from: classes2.dex */
public final class MutablePartitionedIterator<T> implements Iterator<T>, KMarkers {
    private Iterator<? extends T> currentPartitionIterator;
    private final Iterator<Iterable<T>> partitionIterator;

    /* JADX WARN: Multi-variable type inference failed */
    public MutablePartitionedIterator(Iterator<? extends Iterable<? extends T>> it) {
        Intrinsics3.checkNotNullParameter(it, "partitionIterator");
        this.partitionIterator = it;
        Iterator<? extends T> it2 = new LinkedList().iterator();
        Intrinsics3.checkNotNullExpressionValue(it2, "LinkedList<T>().iterator()");
        this.currentPartitionIterator = it2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.currentPartitionIterator.hasNext()) {
            return true;
        }
        while (this.partitionIterator.hasNext()) {
            Iterator<T> it = this.partitionIterator.next().iterator();
            this.currentPartitionIterator = it;
            if (it.hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        return this.currentPartitionIterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentPartitionIterator.remove();
    }
}
