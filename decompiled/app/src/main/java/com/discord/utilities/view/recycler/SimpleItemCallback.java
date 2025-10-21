package com.discord.utilities.view.recycler;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: SimpleItemCallback.kt */
/* loaded from: classes2.dex */
public final class SimpleItemCallback<T> extends DiffUtil.ItemCallback<T> {
    private final Function1<T, Object> idGenerator;

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleItemCallback(Function1<? super T, ? extends Object> function1) {
        Intrinsics3.checkNotNullParameter(function1, "idGenerator");
        this.idGenerator = function1;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    @SuppressLint({"DiffUtilEquals"})
    public boolean areContentsTheSame(T oldItem, T newItem) {
        return Intrinsics3.areEqual(oldItem, newItem);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areItemsTheSame(T oldItem, T newItem) {
        return Intrinsics3.areEqual(this.idGenerator.invoke(oldItem), this.idGenerator.invoke(newItem));
    }
}
