package com.discord.widgets.chat.input.models;

import d0.z.d.m;
import java.util.Iterator;
import java.util.List;

/* compiled from: ApplicationCommandData.kt */
/* loaded from: classes2.dex */
public final class ApplicationCommandDataKt {
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getCommandId(ApplicationCommandData applicationCommandData) {
        Object obj;
        Object next;
        ApplicationCommandValue applicationCommandValue;
        List<ApplicationCommandValue> options;
        Object next2;
        m.checkNotNullParameter(applicationCommandData, "$this$getCommandId");
        Iterator<T> it = applicationCommandData.getValues().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ApplicationCommandValue) next).getType() == 2) {
                break;
            }
        }
        ApplicationCommandValue applicationCommandValue2 = (ApplicationCommandValue) next;
        if (applicationCommandValue2 == null || (options = applicationCommandValue2.getOptions()) == null) {
            Iterator<T> it2 = applicationCommandData.getValues().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next3 = it2.next();
                if (((ApplicationCommandValue) next3).getType() == 1) {
                    obj = next3;
                    break;
                }
            }
            applicationCommandValue = (ApplicationCommandValue) obj;
        } else {
            Iterator<T> it3 = options.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it3.next();
                if (((ApplicationCommandValue) next2).getType() == 1) {
                    break;
                }
            }
            applicationCommandValue = (ApplicationCommandValue) next2;
            if (applicationCommandValue == null) {
            }
        }
        if (applicationCommandValue2 == null || applicationCommandValue == null) {
            if (applicationCommandValue == null) {
                return applicationCommandData.getApplicationCommand().getId();
            }
            return applicationCommandData.getApplicationCommand().getId() + " " + applicationCommandValue.getName();
        }
        return applicationCommandData.getApplicationCommand().getId() + " " + applicationCommandValue2.getName() + " " + applicationCommandValue.getName();
    }
}
