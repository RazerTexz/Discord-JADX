package com.discord.utilities.view.validators;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: InputValidator.kt */
/* loaded from: classes2.dex */
public interface InputValidator<T> {
    CharSequence getErrorMessage(T view);
}
