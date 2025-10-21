package com.discord.widgets.chat.input.models;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import java.util.regex.Pattern;

/* compiled from: TagObject.kt */
/* loaded from: classes2.dex */
public interface TagObject extends MGRecyclerDataPayload {
    String getDisplayTag();

    String getTag();

    Pattern getTagRegex();
}
