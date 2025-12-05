package com.discord.utilities.guildautomod;

import com.discord.api.message.embed.EmbedField;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Iterator;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AutoModUtils.kt */
/* loaded from: classes2.dex */
public final class AutoModUtils {
    public static final AutoModUtils INSTANCE = new AutoModUtils();

    private AutoModUtils() {
    }

    public final String getEmbedFieldValue(MessageEmbed messageEmbed, String name) {
        Object next;
        String value;
        Intrinsics3.checkNotNullParameter(messageEmbed, "messageEmbed");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<EmbedField> listM8101d = messageEmbed.m8101d();
        if (listM8101d != null) {
            Iterator<T> it = listM8101d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics3.areEqual(((EmbedField) next).getName(), name)) {
                    break;
                }
            }
            EmbedField embedField = (EmbedField) next;
            if (embedField != null && (value = embedField.getValue()) != null) {
                return value;
            }
        }
        return "";
    }
}
