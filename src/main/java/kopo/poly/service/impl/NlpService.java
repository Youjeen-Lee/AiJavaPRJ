package kopo.poly.service.impl;

import kopo.poly.dto.NlpDTO;
import kopo.poly.service.INlpService;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service

public class NlpService implements INlpService {

    Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);

    @Override
    public NlpDTO getPlainText(String text) { // 형태소 분석

        log.info(this.getClass().getName() + ".getPlainText Start!"); // 'getclass'라고 오타냄 주의!

        KomoranResult komoranResult = komoran.analyze(text); // 인식된 문자열 분석 결과

        String result = komoranResult.getPlainText(); // 모든 단어마다 품사 태킹

        NlpDTO rDTO = new NlpDTO();
        rDTO.setResult(result); // NlpDTO에 함수가 있어야 set 가능

        log.info(this.getClass().getName() + ".getPlainText End!");

        return rDTO;
    }

    @Override
    public NlpDTO getNouns(String text) { // 명사 추출

        log.info(this.getClass().getName() + ".getNouns Start!");

        KomoranResult komoranResult = komoran.analyze(text); // 인식된 문자열 분석 결과

        List<String> nouns = komoranResult.getNouns(); // NNG(일반명사), NNP(고유명사)만 추출

        NlpDTO rDTO = new NlpDTO();
        rDTO.setNouns(nouns);

        log.info(this.getClass().getName() + ".getNounsEnd!");


        return rDTO;
    }
}
