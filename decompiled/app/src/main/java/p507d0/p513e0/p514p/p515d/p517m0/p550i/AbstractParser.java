package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.MessageLite;

/* compiled from: AbstractParser.java */
/* renamed from: d0.e0.p.d.m0.i.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser2<MessageType> {
    static {
        ExtensionRegistryLite.getEmptyRegistry();
    }

    /* renamed from: a */
    public final MessageType m9822a(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw (messagetype instanceof AbstractMessageLite ? new UninitializedMessageException((AbstractMessageLite) messagetype) : new UninitializedMessageException(messagetype)).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    /* renamed from: parseDelimitedFrom, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m11466parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    /* renamed from: parseFrom, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m11467parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return parseFrom(inputStream, extensionRegistryLite);
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            return (MessageType) parsePartialFrom(new AbstractMessageLite.a.C13324a(inputStream, CodedInputStream.readRawVarint32(i, inputStream)), extensionRegistryLite);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
    }

    public MessageType parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream codedInputStreamNewInstance = CodedInputStream.newInstance(inputStream);
        MessageType partialFrom = parsePartialFrom(codedInputStreamNewInstance, extensionRegistryLite);
        try {
            codedInputStreamNewInstance.checkLastTagWas(0);
            return partialFrom;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(partialFrom);
        }
    }

    public MessageType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) parsePartialDelimitedFrom(inputStream, extensionRegistryLite);
        m9822a(messagetype);
        return messagetype;
    }

    public MessageType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageType messagetype = (MessageType) parsePartialFrom(inputStream, extensionRegistryLite);
        m9822a(messagetype);
        return messagetype;
    }
}
