package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RestCallState.kt */
/* renamed from: com.discord.stores.utilities.Success, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class RestCallState6<T> extends RestCallState<T> {
    private final T response;

    public RestCallState6(T t) {
        super(null);
        this.response = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestCallState6 copy$default(RestCallState6 restCallState6, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = restCallState6.response;
        }
        return restCallState6.copy(obj);
    }

    public final T component1() {
        return this.response;
    }

    public final RestCallState6<T> copy(T response) {
        return new RestCallState6<>(response);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RestCallState6) && Intrinsics3.areEqual(this.response, ((RestCallState6) other).response);
        }
        return true;
    }

    public final T getResponse() {
        return this.response;
    }

    public int hashCode() {
        T t = this.response;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    @Override // com.discord.stores.utilities.RestCallState
    public T invoke() {
        return this.response;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Success(response=");
        sbM833U.append(this.response);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
