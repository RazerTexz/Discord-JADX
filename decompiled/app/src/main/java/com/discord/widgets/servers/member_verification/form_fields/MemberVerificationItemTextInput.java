package com.discord.widgets.servers.member_verification.form_fields;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: MemberVerificationItemTextInput.kt */
/* loaded from: classes2.dex */
public final /* data */ class MemberVerificationItemTextInput implements MemberVerificationItem {
    private final int fieldIndex;
    private final String key;
    private final String response;
    private final int type = 4;

    public MemberVerificationItemTextInput(int i, String str) {
        this.fieldIndex = i;
        this.response = str;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(getType());
        this.key = sb.toString();
    }

    public static /* synthetic */ MemberVerificationItemTextInput copy$default(MemberVerificationItemTextInput memberVerificationItemTextInput, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = memberVerificationItemTextInput.fieldIndex;
        }
        if ((i2 & 2) != 0) {
            str = memberVerificationItemTextInput.response;
        }
        return memberVerificationItemTextInput.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final String getResponse() {
        return this.response;
    }

    public final MemberVerificationItemTextInput copy(int fieldIndex, String response) {
        return new MemberVerificationItemTextInput(fieldIndex, response);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemberVerificationItemTextInput)) {
            return false;
        }
        MemberVerificationItemTextInput memberVerificationItemTextInput = (MemberVerificationItemTextInput) other;
        return this.fieldIndex == memberVerificationItemTextInput.fieldIndex && Intrinsics3.areEqual(this.response, memberVerificationItemTextInput.response);
    }

    public final int getFieldIndex() {
        return this.fieldIndex;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getResponse() {
        return this.response;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.fieldIndex * 31;
        String str = this.response;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MemberVerificationItemTextInput(fieldIndex=");
        sbU.append(this.fieldIndex);
        sbU.append(", response=");
        return outline.J(sbU, this.response, ")");
    }
}
