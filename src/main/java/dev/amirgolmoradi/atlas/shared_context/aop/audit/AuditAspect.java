package dev.amirgolmoradi.atlas.shared_context.aop.audit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    @After("@annotation(audit)")
    public void afterAudit(JoinPoint jp, Audit audit) {
        System.out.println("AUDIT: " + audit.action() + " executed.");
    }

}
