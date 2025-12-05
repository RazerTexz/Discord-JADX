package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.p279z2.Metadata2;

/* loaded from: classes3.dex */
public abstract class Id3Frame implements Metadata.Entry {

    /* renamed from: j */
    public final String f19989j;

    public Id3Frame(String str) {
        this.f19989j = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: n */
    public /* synthetic */ void mo8878n(MediaMetadata.b bVar) {
        Metadata2.m3894c(this, bVar);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: o0 */
    public /* synthetic */ byte[] mo8879o0() {
        return Metadata2.m3892a(this);
    }

    public String toString() {
        return this.f19989j;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    /* renamed from: y */
    public /* synthetic */ Format2 mo8880y() {
        return Metadata2.m3893b(this);
    }
}
