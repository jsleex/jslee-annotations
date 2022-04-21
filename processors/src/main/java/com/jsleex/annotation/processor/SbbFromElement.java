package com.jsleex.annotation.processor;

import com.jsleex.annotation.processor.xml.common.*;
import com.jsleex.annotation.processor.xml.sbb.*;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.slee.ActivityContextInterface;
import javax.slee.SbbLocalObject;
import javax.tools.Diagnostic;
import java.util.LinkedList;
import java.util.List;

public class SbbFromElement implements XmlFromElement<Sbb, com.jsleex.annotation.Sbb>{
    private final ProcessingEnvironment processingEnv;

    public SbbFromElement(ProcessingEnvironment annotationFinder) {
        this.processingEnv = annotationFinder;
    }

    @Override
    public List<Sbb> generate(Element element) {
        List<Sbb> sbbs = new LinkedList<>();
        if (element.getKind().isClass() && element.getModifiers().contains(Modifier.ABSTRACT)) {
            com.jsleex.annotation.Sbb sbbAnnotation = element.getAnnotation(com.jsleex.annotation.Sbb.class);
            final Sbb sbb = new Sbb();
            fillInSbbComponentName(sbbAnnotation, sbb);
            fillInLibraryRefs(element, sbb);
            fillInSbbRefs(element, sbb);
            fillInProfileRefs(element, sbb);
            fillInSbbClasses(element, sbbAnnotation, sbb);
            fillInAddressProfileRef(sbbAnnotation, sbb);
            fillInEvents(element, sbb);
            fillInAciAttributeAliases(element, sbb);
            fillInEnvEntries(element, sbb);
            fillInRaBindings(element, sbb);
            fillInEjbRefs(element, sbb);

            if (!sbbAnnotation.securityPermissions().isEmpty())  {
                SecurityPermissions securityPermissions = new SecurityPermissions();
                SecurityPermissionSpec securityPermissionSpec = new SecurityPermissionSpec();

                securityPermissions.setSecurityPermissionSpec(securityPermissionSpec);
            }
            sbbs.add(sbb);
        } else {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, element.getSimpleName() + " contains com.jsleex.annotation.Sbb annotation but it's not an abstract class.");
        }
        return sbbs;
    }

    private void fillInAciAttributeAliases(Element element, Sbb sbb) {
        final AciAttributeAliasFromElement aciAttributeAliasFromElement = new AciAttributeAliasFromElement(processingEnv);
        sbb.getActivityContextAttributeAlias().addAll(aciAttributeAliasFromElement.generate(element));
    }

    private void fillInEjbRefs(Element element, Sbb sbb) {
        final EjbRefsFromElement ejbRefsFromElement = new EjbRefsFromElement(processingEnv);
        sbb.getEjbRef().addAll(ejbRefsFromElement.generate(element));
    }

    private void fillInRaBindings(Element element, Sbb sbb) {
        final ResourceAdaptorTypeRefsFromElement resourceAdaptorTypeRefsFromElement = new ResourceAdaptorTypeRefsFromElement(processingEnv);
        sbb.getResourceAdaptorTypeBinding().addAll(resourceAdaptorTypeRefsFromElement.generate(element));
    }

    private void fillInAddressProfileRef(com.jsleex.annotation.Sbb sbbAnnotation, Sbb sbb) {
        if (!sbbAnnotation.addressProfileSpecAliasRef().isEmpty()) {
            final AddressProfileSpecAliasRef addressProfileSpecAliasRef = new AddressProfileSpecAliasRef();
            addressProfileSpecAliasRef.setvalue(sbbAnnotation.addressProfileSpecAliasRef());
            sbb.setAddressProfileSpecAliasRef(addressProfileSpecAliasRef);
        }
    }

    private void fillInLibraryRefs(Element element, Sbb sbb) {
        final LibraryRefsFromElement libraryRefsFromElement = new LibraryRefsFromElement(processingEnv);
        sbb.getLibraryRef().addAll(libraryRefsFromElement.generate(element));
    }

    private void fillInEvents(Element element, Sbb sbb) {
        final EventsFromElement profileSpecRefFromElement = new EventsFromElement(processingEnv);
        sbb.getEvent().addAll(profileSpecRefFromElement.generate(element));

    }

    private void fillInProfileRefs(Element element, Sbb sbb) {
        final ProfileSpecRefFromElement profileSpecRefFromElement = new ProfileSpecRefFromElement(processingEnv);
        sbb.getProfileSpecRef().addAll(profileSpecRefFromElement.generate(element));
    }

    private void fillInEnvEntries(Element element, Sbb sbb) {
        final EnvEntriesFromElement envEntriesFromElement = new EnvEntriesFromElement(new AnnotationFinder(processingEnv.getTypeUtils()));
        sbb.getEnvEntry().addAll(envEntriesFromElement.generate(element));
    }

    private void fillInSbbRefs(Element element, Sbb sbb) {
        final List<SbbRef> sbbRefs = new LinkedList<>();
        for (com.jsleex.annotation.SbbRef sbbRefAnnotation : element.getAnnotationsByType(com.jsleex.annotation.SbbRef.class)) {
            final SbbRef sbbRef = new SbbRef();
            final SbbAlias sbbAlias = new SbbAlias();
            sbbAlias.setvalue(sbbRefAnnotation.alias());
            sbbRef.setSbbAlias(sbbAlias);
            final SbbName sbbName = new SbbName();
            sbbName.setvalue(sbbRefAnnotation.name());
            sbbRef.setSbbName(sbbName);
            final SbbVendor sbbVendor = new SbbVendor();
            sbbVendor.setvalue(sbbRefAnnotation.vendor());
            sbbRef.setSbbVendor(sbbVendor);
            final SbbVersion sbbVersion = new SbbVersion();
            sbbVersion.setvalue(sbbRefAnnotation.version());
            sbbRef.setSbbVersion(sbbVersion);
            sbbRefs.add(sbbRef);
        }
        sbb.getSbbRef().addAll(sbbRefs);
    }

    private void fillInSbbClasses(Element element, com.jsleex.annotation.Sbb sbbAnnotation, Sbb sbb) {
        final SbbClasses sbbClasses = new SbbClasses();
        fillInSbbAbstractClass(element, sbbAnnotation, sbbClasses);
        fillInSbbLocalInterface(sbbAnnotation, sbbClasses);
        fillInSbbUsageParametersInterface(sbbAnnotation, sbbClasses);
        fillInSbbActivityContextInterface(sbbAnnotation, sbbClasses);
        sbb.setSbbClasses(sbbClasses);
    }

    private void fillInSbbActivityContextInterface(com.jsleex.annotation.Sbb sbbAnnotation, SbbClasses sbbClasses) {
        //ugly
        try {
            sbbAnnotation.sbbActivityContextInterfaceName();
        } catch (MirroredTypeException mte) {
            final TypeMirror typeMirror = mte.getTypeMirror();
            final String className = typeMirror.toString();
            if (!className.equals(ActivityContextInterface.class.getCanonicalName())) {
                final SbbActivityContextInterface sbbActivityContextInterface = new SbbActivityContextInterface();
                final SbbActivityContextInterfaceName sbbActivityContextInterfaceName = new SbbActivityContextInterfaceName();
                sbbActivityContextInterfaceName.setvalue(className);
                sbbActivityContextInterface.setSbbActivityContextInterfaceName(sbbActivityContextInterfaceName);
                final Description description = new Description();
                description.setvalue(sbbAnnotation.sbbActivityContextInterfaceDescription());
                sbbActivityContextInterface.setDescription(description);
                sbbClasses.setSbbActivityContextInterface(sbbActivityContextInterface);
            }
        }
    }

    private void fillInSbbAbstractClass(Element element, com.jsleex.annotation.Sbb sbbAnnotation, SbbClasses sbbClasses) {
        final SbbAbstractClass sbbAbstractClass = new SbbAbstractClass();
        final SbbAbstractClassName sbbAbstractClassName = new SbbAbstractClassName();
        sbbAbstractClassName.setvalue(element.toString());
        sbbAbstractClass.setSbbAbstractClassName(sbbAbstractClassName);
        if (sbbAnnotation.reentrant()) {
            sbbAbstractClass.setReentrant("True");
        }
        final CmpFromElement cmpFromElement = new CmpFromElement(processingEnv);
        sbbAbstractClass.getCmpField().addAll(cmpFromElement.generate(element));
        final ChildRelationFromElement childRelationFromElement = new ChildRelationFromElement(processingEnv);
        sbbAbstractClass.getGetChildRelationMethod().addAll(childRelationFromElement.generate(element));
        final ProfileCmpFromElement profileCmpFromElement = new ProfileCmpFromElement(processingEnv);
        sbbAbstractClass.getGetProfileCmpMethod().addAll(profileCmpFromElement.generate(element));
        sbbClasses.setSbbAbstractClass(sbbAbstractClass);
    }

    private void fillInSbbComponentName(com.jsleex.annotation.Sbb sbbAnnotation, Sbb sbb) {
        final SbbName sbbName = new SbbName();
        sbbName.setvalue(sbbAnnotation.name());
        sbb.setSbbName(sbbName);
        final SbbVendor sbbVendor = new SbbVendor();
        sbbVendor.setvalue(sbbAnnotation.vendor());
        sbb.setSbbVendor(sbbVendor);
        final SbbVersion sbbVersion = new SbbVersion();
        sbbVersion.setvalue(sbbAnnotation.version());
        sbb.setSbbVersion(sbbVersion);
    }

    private void fillInSbbUsageParametersInterface(com.jsleex.annotation.Sbb sbbAnnotation, SbbClasses sbbClasses) {
        //ugly
        try {
            sbbAnnotation.sbbUsageParameterInterfaceName();
        } catch (MirroredTypeException mte) {
            final TypeMirror typeMirror = mte.getTypeMirror();
            final String className = typeMirror.toString();
            if (!className.equals(void.class.getCanonicalName())) {
                final SbbUsageParametersInterface sbbUsageParametersInterface = new SbbUsageParametersInterface();
                //todo
//            sbbUsageParametersInterface.setDescription();
                sbbClasses.setSbbUsageParametersInterface(sbbUsageParametersInterface);
            }
        }
    }

    private void fillInSbbLocalInterface(com.jsleex.annotation.Sbb sbbAnnotation, SbbClasses sbbClasses) {
        //ugly
        try {
            sbbAnnotation.sbbLocalInterfaceName();
        } catch (MirroredTypeException mte) {
            final TypeMirror typeMirror = mte.getTypeMirror();
            final String className = typeMirror.toString();
            if (!SbbLocalObject.class.getCanonicalName().equals(className)) {
                final SbbLocalInterface sbbLocalInterface = new SbbLocalInterface();
                final SbbLocalInterfaceName sbbLocalInterfaceName = new SbbLocalInterfaceName();
                sbbLocalInterfaceName.setvalue(className);
                sbbLocalInterface.setSbbLocalInterfaceName(sbbLocalInterfaceName);
                sbbClasses.setSbbLocalInterface(sbbLocalInterface);
            }
        }
    }
}
