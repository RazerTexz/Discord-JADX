package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: ListenerCollection.kt */
/* loaded from: classes2.dex */
public interface ListenerCollection<T> {
    void add(T listener);

    boolean remove(T listener);
}
